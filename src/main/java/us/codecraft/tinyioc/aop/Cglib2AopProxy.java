package us.codecraft.tinyioc.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yihua.huang@dianping.com
 */
public class Cglib2AopProxy extends AbstractAopProxy {

	public Cglib2AopProxy(AdvisedSupport advised) {
		super(advised);
	}

	//通过cglib类库创建了一个代理类的实例
	@Override
	public Object getProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(advised.getTargetSource().getTargetClass());
		enhancer.setInterfaces(advised.getTargetSource().getInterfaces());
		//设置代理类的通知方法，相当于设置拦截器方法
		enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
		Object enhanced = enhancer.create();
		return enhanced;
	}

	//方法拦截器
	private static class DynamicAdvisedInterceptor implements MethodInterceptor {

		private AdvisedSupport advised;

		private org.aopalliance.intercept.MethodInterceptor delegateMethodInterceptor;

		private DynamicAdvisedInterceptor(AdvisedSupport advised) {
			this.advised = advised;
			this.delegateMethodInterceptor = advised.getMethodInterceptor();
		}

		//调用代理类的方法（代理类与原始类是父子关系，还有一种是兄弟关系，调用实质是调用原始类的方法）
		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			if (advised.getMethodMatcher() == null
					|| advised.getMethodMatcher().matches(method, advised.getTargetSource().getTargetClass())) {
				//这里也应该是先调用拦截方法，然后调用原始对象的方法
				return delegateMethodInterceptor.invoke(new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, args, proxy));
			}
			return new CglibMethodInvocation(advised.getTargetSource().getTarget(), method, args, proxy).proceed();
		}
	}

	private static class CglibMethodInvocation extends ReflectiveMethodInvocation {

		private final MethodProxy methodProxy;

		public CglibMethodInvocation(Object target, Method method, Object[] args, MethodProxy methodProxy) {
			super(target, method, args);
			this.methodProxy = methodProxy;
		}

		@Override
		public Object proceed() throws Throwable {
			return this.methodProxy.invoke(this.target, this.arguments);
		}
	}

}

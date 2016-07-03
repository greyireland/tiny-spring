package us.codecraft.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author yihua.huang@dianping.com
 */
/**
 * 切点通知方法？未知
 * @author tengyu
 *
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

	@Override
	public Advice getAdvice() {
		return advice;
	}

    @Override
	public Pointcut getPointcut() {
		return pointcut;
	}
}

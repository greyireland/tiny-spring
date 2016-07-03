package us.codecraft.tinyioc.aop;

import java.lang.reflect.Method;

/**
 * @author yihua.huang@dianping.com
 */
/**
 * 匹配方法
 * @author tengyu
 *
 */
public interface MethodMatcher {

    boolean matches(Method method, Class targetClass);
}

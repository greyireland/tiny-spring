package us.codecraft.tinyioc.aop;

/**
 * @author yihua.huang@dianping.com
 */
/**
 * 切点接口，Class匹配和方法匹配
 * @author tengyu
 *
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}

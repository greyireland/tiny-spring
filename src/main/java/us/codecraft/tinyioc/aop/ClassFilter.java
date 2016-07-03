package us.codecraft.tinyioc.aop;

/**
 * @author yihua.huang@dianping.com
 */
/**
 * 匹配Class实例
 * @author tengyu
 *
 */
public interface ClassFilter {

    boolean matches(Class targetClass);
}

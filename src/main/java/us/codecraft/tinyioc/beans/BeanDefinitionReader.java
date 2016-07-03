package us.codecraft.tinyioc.beans;

/**
 * 从配置中读取BeanDefinition，加载所有bean
 * @author yihua.huang@dianping.com
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}

package us.codecraft.tinyioc.aop;

import us.codecraft.tinyioc.beans.factory.BeanFactory;

/**
 * @author yihua.huang@dianping.com
 */
/**
 * 设置bean工厂
 * @author tengyu
 *
 */
public interface BeanFactoryAware {

    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}

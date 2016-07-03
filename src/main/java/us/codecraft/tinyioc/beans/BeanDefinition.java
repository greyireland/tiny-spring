package us.codecraft.tinyioc.beans;

/**
 * bean的内容及元数据，保存在BeanFactory中，包装bean的实体
 * 
 * @author yihua.huang@dianping.com
 */
public class BeanDefinition {

	private Object bean;

	//类的Class对象
	private Class beanClass;

	//类名
	private String beanClassName;

	//保存所有的属性，bean的引用也算一种属性吧。
	private PropertyValues propertyValues = new PropertyValues();

	public BeanDefinition() {
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		try {
			//加载类，并返回class对象
			//这里已经有了类的实例了，但是没有引用，怎么可以获取这个引用呢？
			this.beanClass = Class.forName(beanClassName);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object getBean() {
		return bean;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
}

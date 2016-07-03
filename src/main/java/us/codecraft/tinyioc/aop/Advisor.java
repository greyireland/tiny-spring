package us.codecraft.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author yihua.huang@dianping.com
 */
public interface Advisor {

	//获取通知事件
    Advice getAdvice();
}

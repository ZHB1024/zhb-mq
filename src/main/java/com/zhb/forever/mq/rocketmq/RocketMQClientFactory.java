package com.zhb.forever.mq.rocketmq;

import com.zhb.forever.framework.spring.bean.locator.SpringBeanLocator;
import com.zhb.forever.mq.Constants;
import com.zhb.forever.mq.rocketmq.client.RocketMQClient;

public class RocketMQClientFactory {
    
    public static RocketMQClient getRocketMQClientBean() {
        Object bean = SpringBeanLocator.getInstance(
                Constants.ROCKET_MQ_CLIENT_CONF).getBean(
                        Constants.ROCKET_MQ_CLIENT);
        return (RocketMQClient) bean;
    }
    
}

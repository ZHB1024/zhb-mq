package com.zhb.forever.mq.rabbitmq;

import com.zhb.forever.framework.spring.bean.locator.SpringBeanLocator;
import com.zhb.forever.mq.Constants;
import com.zhb.forever.mq.rabbitmq.client.RabbitMQClient;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2019年1月21日下午1:28:08
*/

public class RabbitMQClientFactory {

    public RabbitMQClient getRabbitMQClientBean() {
        Object bean = SpringBeanLocator.getInstance(
                Constants.RABBIT_MQ_CLIENT_CONF).getBean(
                        Constants.RABBIT_MQ_CLIENT);
        return (RabbitMQClient) bean;
    }

}



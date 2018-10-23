package com.zhb.forever.mq.client;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;

import com.zhb.forever.framework.spring.bean.locator.SpringBeanLocator;
import com.zhb.forever.mq.Constants;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2018年10月23日上午11:23:03
*/

public class JmsActiveMQClientFactory {


    public static JmsActiveMQManager getRedisClientBean() {
        Object bean = SpringBeanLocator.getInstance(
                Constants.MQ_CLIENT_CONF).getBean(
                        Constants.MQ_CLIENT);
        return (JmsActiveMQManager) bean;
    }
    
    public static Destination getMQDestinationBean() {
        Object bean = SpringBeanLocator.getInstance(
                Constants.MQ_CLIENT_CONF).getBean(
                        Constants.MQ_DESTINATION);
        return (Destination) bean;
    }
}



package com.zhb.forever.mq.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import com.zhb.forever.framework.spring.bean.locator.SpringBeanLocator;
import com.zhb.forever.mq.Constants;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2018年10月24日下午4:59:39
*/

public class KafkaFactory {
    
    public static KafkaTemplate getKafkaProducerTemplateBean() {
        Object bean = SpringBeanLocator.getInstance(
                Constants.KAFKA_CONF).getBean(
                        Constants.KAFKA_PRODUCER_TEMPLATE);
        return (KafkaTemplate) bean;
    }
    
}



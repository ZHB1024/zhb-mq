package com.zhb.forever.mq;

public class Constants {

    public static final String ACTIVE_MQ_CLIENT_CONF = "active_mq_client.xml";
    public static final String ACTIVE_MQ_CLIENT = "activeMQClientImpl";
    public static final String ACTIVE_MQ_DEFAULT_DESTINATION = "activeMQDestination";
    
    public static final String ACTIVE_MQ_DEFAULT_DESTINATION_NAME = "zhb_vue";
    public static final String ACTIVE_MQ_KEYVALUE_DESTINATION_NAME = "key_value_protobuf";
    
    
    public static final String KAFKA_CONF = "kafka_client.xml";
    public static final String KAFKA_PRODUCER_TEMPLATE = "kafkaProducerTemplate";
    
    //rocketMQ
    public static final String ROCKET_MQ_CLIENT_CONF = "rocket_mq_client.xml";
    public static final String ROCKET_MQ_CLIENT = "rocketMQClientImpl";
    
    //rabbitMQ
    public static final String RABBIT_MQ_CLIENT_CONF = "rabbit_mq_client.xml";
    public static final String RABBIT_MQ_CLIENT = "rabbitMQClientImpl";
    
    public static final int RING_BUFFER_SIZE = 1024*1024;// RingBuffer 大小，必须是 2 的 N 次方；

}

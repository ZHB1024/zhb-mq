package com.zhb.forever.mq.disruptor.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.WorkHandler;
import com.zhb.forever.framework.vo.KeyValueVO;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2018年12月18日下午3:11:27
*/

public abstract class Consumer implements WorkHandler<KeyValueVO> {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    
    protected final String name;
    
    public Consumer(String name) {
        this.name = name;
    }
    
    @Override
    public void onEvent(KeyValueVO event) throws Exception {
        logger.info("consumeThread"+ name + "***********开始");
        consume(event.getKey(), event.getValue());
        logger.info("consumeThread"+ name + "***********结束");
    }
    
    public abstract void consume(String key,String value) ;

}



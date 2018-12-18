package com.zhb.forever.mq.disruptor.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.RingBuffer;
import com.zhb.forever.framework.vo.KeyValueVO;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2018年12月18日下午3:13:39
*/

public abstract class Producer {
    
    private final Logger logger = LoggerFactory.getLogger(Producer.class);
    
    protected final RingBuffer<KeyValueVO> ringBuffer;
    protected final String name;
    
    public Producer(RingBuffer<KeyValueVO> ringBuffer,String name) {
        this.ringBuffer = ringBuffer;
        this.name = name;
    }
    
    public abstract void produce() ;

    private void pushData(String key,String value) {
        long sequence = ringBuffer.next();
        try {
            KeyValueVO vo = ringBuffer.get(sequence);
            vo.setKey(key);
            vo.setValue(value);
        }finally {
            ringBuffer.publish(sequence);
            logger.info("生产者-" + name + "：发布成功------");
        }
    }
}



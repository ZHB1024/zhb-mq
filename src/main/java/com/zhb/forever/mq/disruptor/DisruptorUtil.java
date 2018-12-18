package com.zhb.forever.mq.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.zhb.forever.framework.vo.KeyValueVO;
import com.zhb.forever.mq.Constants;
import com.zhb.forever.mq.disruptor.consumer.Consumer;
import com.zhb.forever.mq.disruptor.event.KeyValueVOFactory;
import com.zhb.forever.mq.disruptor.producer.Producer;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2018年12月18日下午3:23:35
*/

public class DisruptorUtil {
    
    private final Logger logger = LoggerFactory.getLogger(DisruptorUtil.class);
    
    public static Disruptor<KeyValueVO> getDisruptor(){
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        KeyValueVOFactory voFactory = new KeyValueVOFactory();
        Disruptor<KeyValueVO> disruptor = new Disruptor<KeyValueVO>(voFactory, Constants.RING_BUFFER_SIZE,threadFactory,
                ProducerType.MULTI,new SleepingWaitStrategy());
        return disruptor;
    }
    
    
    public static void testDisruptor() {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        KeyValueVOFactory voFactory = new KeyValueVOFactory();
        Disruptor<KeyValueVO> disruptor = new Disruptor<KeyValueVO>(voFactory, Constants.RING_BUFFER_SIZE,threadFactory,
                ProducerType.MULTI,new SleepingWaitStrategy());
        
        
        disruptor.handleEventsWithWorkerPool(new Consumer[] {new Consumer("消费者1"),new Consumer("消费者2")});
        disruptor.start();
        
        RingBuffer<KeyValueVO> ringBuffer = disruptor.getRingBuffer();
        
        for(int i =0 ; i < 10 ; i++) {
            //Producer producer = new Producer(ringBuffer,"生产者"+i);
            //producer.pushData();
        }
        
        disruptor.shutdown();
    }
    
    public static void main(String[] args) {
    }

}



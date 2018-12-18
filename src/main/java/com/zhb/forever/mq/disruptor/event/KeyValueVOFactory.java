package com.zhb.forever.mq.disruptor.event;

import com.lmax.disruptor.EventFactory;
import com.zhb.forever.framework.vo.KeyValueVO;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2018年12月18日下午3:09:47
*/

public class KeyValueVOFactory implements EventFactory<KeyValueVO> {

    @Override
    public KeyValueVO newInstance() {
        return new KeyValueVO();
    }

}



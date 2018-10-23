package com.zhb.forever.mq.client.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.zhb.forever.mq.client.JmsActiveMQManager;

/**
*@author   zhanghb<a href="mailto:zhb20111503@126.com">zhanghb</a>
*@createDate 2018年10月23日上午11:15:15
*/

public class JmsActiveMQManagerImpl implements JmsActiveMQManager {
    
    private Logger logger = LoggerFactory.getLogger(JmsActiveMQManagerImpl.class);
    
    private JmsTemplate jmsQueueTemplate;
    
    private JmsTemplate jmsTopicTemplate;
    

    /*------Quene begin---------------------------------------*/
    public void sendQueueDestinationMsg(Destination destination, final String msg) {
        logger.info("向队列" + destination.toString() + "发送了消息------------" + msg);
        jmsQueueTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
    
    public void sendQueueDestinationNameMsg(String destinationName, final String msg) {
        logger.info("向队列" + destinationName + "发送了消息------------" + msg);
        jmsQueueTemplate.send(destinationName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
    
    public void sendQueueMessage(final String msg) {
        String destination = jmsQueueTemplate.getDefaultDestination().toString();
        logger.info("向队列" + destination + "发送了消息------------" + msg);
        jmsQueueTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
    
    public void sendQueueRemoteMsg(String destinationName, byte[] msg) {
        /*logger.info("向队列" + destinationName + "发送了消息------------" + msg.toString());
        ProtoResult pr = new ProtoResult();
        pr.setProtoBytes(msg);
        jmsQueueTemplate.send(destinationName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(pr);
            }
        });*/
    }

    public TextMessage receiveQueueMessage(Destination destination) {
        Message m = jmsQueueTemplate.receive(destination);
        TextMessage tm = null;
        if (null != m) {
            tm = (TextMessage)m;
            try {
                logger.info("从队列" + destination.toString() + "收到了消息：\t" + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return tm;
    }
    
    public TextMessage receiveQueueMessage(String destinationName) {
        Message m = jmsQueueTemplate.receive(destinationName);
        TextMessage tm = null;
        if (null != m) {
            tm = (TextMessage)m;
            try {
                logger.info("从队列" + destinationName + "收到了消息：\t" + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return tm;
    }
    
/*------Quene end---------------------------------------*/

    
    
/*------Topic begin---------------------------------------*/
    @Override
    public void sendTopicMessage(String destinationName, String msg) {
        logger.info("向topic" + destinationName + "发送了消息------------" + msg);
        jmsTopicTemplate.send(destinationName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    @Override
    public TextMessage receiveTopicMessage(String destinationName) {
        Message m = jmsTopicTemplate.receive(destinationName);
        TextMessage tm = null;
        if (null != m) {
            tm = (TextMessage)m;
            try {
                logger.info("从topic" + destinationName + "收到了消息：\t" + tm.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return tm;
    }

    /*------Topic end---------------------------------------*/
    
    
    
    public JmsTemplate getJmsQueueTemplate() {
        return jmsQueueTemplate;
    }

    public void setJmsQueueTemplate(JmsTemplate jmsQueueTemplate) {
        this.jmsQueueTemplate = jmsQueueTemplate;
    }

    public JmsTemplate getJmsTopicTemplate() {
        return jmsTopicTemplate;
    }

    public void setJmsTopicTemplate(JmsTemplate jmsTopicTemplate) {
        this.jmsTopicTemplate = jmsTopicTemplate;
    }   
}



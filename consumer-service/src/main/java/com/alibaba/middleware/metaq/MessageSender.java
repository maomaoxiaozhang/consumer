package com.alibaba.middleware.metaq;

import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.taobao.metaq.client.MetaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Autowired
    MetaProducer metaProducer;

    public void sendMessage(String msgBody) throws Exception {
        Message msg = new Message("Jodie_topic_1023", // topic
                "TagA", // tag
                "OrderID001", // key，消息的Key字段是为了唯一标识消息的，方便运维排查问题。如果不设置Key，则无法定位消息丢失原因。
                msgBody.getBytes(MetaqMessageListener.UTF_8));// body
        SendResult sendResult = metaProducer.send(msg);

        System.err.println("send message: " +  msgBody);
        System.err.println("send status: " + sendResult.getSendStatus());
    }
}

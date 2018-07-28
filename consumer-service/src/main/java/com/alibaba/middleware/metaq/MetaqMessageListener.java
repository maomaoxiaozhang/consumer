package com.alibaba.middleware.metaq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.List;

@Service(value = "metaqMessageListener")
public class MetaqMessageListener implements MessageListenerConcurrently {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        System.out.println(list.size());
        for (MessageExt msg : list) {
//            System.err.println("receive: " + msg);
            String receivedMsg = new String(msg.getBody(), UTF_8);
            System.err.println("receivedMsg: " + receivedMsg);
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

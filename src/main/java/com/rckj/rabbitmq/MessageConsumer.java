package com.rckj.rabbitmq;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

public class MessageConsumer implements ChannelAwareMessageListener {
   private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("收到消息1 : " + new String(body));
        //确认消息成功消费
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}

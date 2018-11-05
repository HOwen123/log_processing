package com.rckj.rabbitmq;


import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(" 回调id:" + correlationData);
        if (b) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + s+"\n重新发送");

        }
    }
}

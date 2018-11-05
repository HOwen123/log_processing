package com.rckj.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rckj.dao.StudentDao;
import com.rckj.model.Student;
import com.rckj.util.FastJsonConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageConsumer2 implements ChannelAwareMessageListener {

    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private StudentDao studentDao;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        String string = new String(body);
        Student student = FastJsonConvertUtils.convertJsonToObject(string,Student.class);
        System.out.println("收到消息2 : " + student.getName());
        studentDao.saveStudent(student);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

    }
}

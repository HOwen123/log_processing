package com.rckj.controller;

import com.rckj.config.ConnectionFactoryConfigure;
import com.rckj.model.Student;
import com.rckj.util.FastJsonConvertUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/log")
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String send3() throws UnsupportedEncodingException {
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        Student student = new Student();
        student.setId(2);
        student.setName("howen");
        student.setSex("男");
        student.setAge(12);
        rabbitTemplate.convertAndSend(ConnectionFactoryConfigure.EXCHANGE, ConnectionFactoryConfigure.ROUTINGKEY2, FastJsonConvertUtils.convertObjectToJson(student), correlationId);
        return uuid;
    }

}

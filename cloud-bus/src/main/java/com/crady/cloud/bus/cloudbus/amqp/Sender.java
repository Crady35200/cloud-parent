package com.crady.cloud.bus.cloudbus.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:Crady
 * @date:2018/7/17 14:42
 * @desc:
 **/
@Component
public class Sender {

    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg = "this is a message";
        logger.info("send a message:{}",msg);
        amqpTemplate.convertAndSend("TEST_MSG",msg);
    }
}

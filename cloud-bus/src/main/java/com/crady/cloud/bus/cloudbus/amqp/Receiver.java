package com.crady.cloud.bus.cloudbus.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author:Crady
 * @date:2018/7/17 14:48
 * @desc:
 **/
@Component
@RabbitListener(queues = "TEST_MSG")
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void process(String msg){
        logger.info("Receiver:{}",msg);
    }

}

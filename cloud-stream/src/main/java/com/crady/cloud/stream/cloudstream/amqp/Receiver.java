package com.crady.cloud.stream.cloudstream.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author:Crady
 * @date:2018/7/18 14:32
 * @desc:
 **/
@EnableBinding(Sink.class)
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object msg){
        logger.info("===================Receive a message :{}",msg);
    }
}

package com.crady.cloud.bus.cloudbus.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:Crady
 * @date:2018/7/17 14:50
 * @desc:
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue TestQueue(){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return  new Queue("TEST_MSG");
    }
}

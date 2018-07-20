package com.crady.cloud.bus.cloudbus;

import com.crady.cloud.bus.cloudbus.amqp.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudBusApplicationTests {

    @Autowired
    Sender sender;

    @Test
    public void sendMsg() {
        sender.send();
        System.out.println("***************************************");
    }

}

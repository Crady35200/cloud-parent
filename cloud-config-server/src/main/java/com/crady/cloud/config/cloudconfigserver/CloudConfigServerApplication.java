package com.crady.cloud.config.cloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigServer
@EnableFeignClients
@EnableDiscoveryClient
public class CloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerApplication.class, args);
    }
}

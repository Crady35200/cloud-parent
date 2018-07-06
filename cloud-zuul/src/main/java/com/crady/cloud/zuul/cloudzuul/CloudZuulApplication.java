package com.crady.cloud.zuul.cloudzuul;

import com.crady.cloud.zuul.cloudzuul.fillter.AuthorityFillter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

    @Bean
    public AuthorityFillter authorityFillter(){
        return new AuthorityFillter();
    }
}

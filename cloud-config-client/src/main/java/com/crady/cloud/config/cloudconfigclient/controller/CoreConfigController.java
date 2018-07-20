package com.crady.cloud.config.cloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Crady
 * @date:2018/7/11 15:11
 * @desc:
 **/
@RestController
@RequestMapping("core")
@RefreshScope
public class CoreConfigController {

    @Value("${user.name}")
    private String userName;
    @Value("${user.age}")
    private int age;

    @Autowired
    private Environment environment;

    @RequestMapping("core")
    public Object getCoreConfigProperty(){
         return "@Value获取方式---姓名:姓名:" + userName + ",年龄:" + age;
    }
    @RequestMapping("env")
    public Object getOuterConfigProperty(String key){
         return "Environment获取方式---" + environment.getProperty(key,"undefined");
    }
}

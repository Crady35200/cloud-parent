package com.crady.cloud.cloudservice.controller;

import com.crady.cloud.api.bean.User;
import com.crady.cloud.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Random;

/**
 * @author:Crady
 * @date:2018/6/21 17:52
 * @desc:
 **/
@RestController
public class UserController implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public String hello(String words) {
        logger.info("Hi,{} !",words);
        return "Hi," + words + " !";
    }

    public User editUser(@RequestBody User user) {
        int timeout = new Random().nextInt(8000);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("休眠{}豪秒",timeout);
        User u = new User();
        u.setId(user.getId() + 1);
        u.setName(user.getName() + "-new");
        u.setAge(user.getAge() + 1);
        Calendar c = Calendar.getInstance();
        c.setTime(user.getBirthday());
        c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH) + 1);
        u.setBirthday(c.getTime());
        return u;
    }
}

package com.crady.cloud.cloudconsumer.controller;

import com.crady.cloud.api.bean.User;
import com.crady.cloud.cloudconsumer.service.UserFallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author:Crady
 * @date:2018/6/26 18:02
 * @desc:
 **/
@RestController
@RequestMapping("u")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserFallbackService userService;

    @RequestMapping("say")
    public String say(){
        return userService.hello("xiaoming");
    }

    @RequestMapping("edit")
    public Object edit(@RequestParam(value = "id",defaultValue = "8") Long id,
                     @RequestParam(value = "name",defaultValue = "ming") String name,
                     @RequestParam(value = "age",defaultValue = "88") int age,
                     @RequestParam(value = "birthday",defaultValue = "2018-06-27") String birthday){

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logger.info("修改之前:{}",user);
        User u = userService.editUser(user);
        logger.info("修改之后:{}",u);
        return u;
    }
}

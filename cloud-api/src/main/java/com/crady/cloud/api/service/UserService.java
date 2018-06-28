package com.crady.cloud.api.service;

import com.crady.cloud.api.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:Crady
 * @date:2018/6/26 17:59
 * @desc:
 **/
@RequestMapping("user")
public interface UserService {
    @RequestMapping("hello")
    String hello(@RequestParam("words") String words);

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    User editUser(@RequestBody User user);
}

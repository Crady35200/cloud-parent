package com.crady.cloud.api.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:Crady
 * @date:2018/6/27 9:33
 * @desc:
 **/
@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private Date birthday;
}

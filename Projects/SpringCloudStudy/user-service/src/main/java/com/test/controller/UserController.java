package com.test.controller;

/**
 * @author Jkevin
 * @date 2022年10月12日 0:15
 */

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/user/{uid}")
    public User getUserById(@PathVariable("uid")int uid){
        System.out.println("被调用");
        return userService.getUserById(uid);
    }
}

package com.demo.interfaces;

import com.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/20 14:23
 */
@RestController
@RequestMapping("/")
public class TestDb {
    @Resource
    UserService userService;

    @RequestMapping("/inter")
    public String test(){
        return userService.test();
    }

}

package com.demo.controller;

import com.demo.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/20 14:23
 * @description 请添加描述
 */
@RestController
@RequestMapping("/")
public class UrlTestController {
    @Resource
    UserService userService;

    @RequestMapping("/")
    public String test(){
        return userService.test();
    }

}

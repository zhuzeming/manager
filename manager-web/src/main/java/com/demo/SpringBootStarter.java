package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/20 14:37
 * @description 请添加描述 rebase
 */
@MapperScan("com.demo.dao")
@ServletComponentScan("com.demo.service")
@SpringBootApplication
public class SpringBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }

}

package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * interface starter
 *
 * @author admin
 */
@MapperScan("com.demo.dao")
@ServletComponentScan("com.demo.service")
@SpringBootApplication
public class InterfaceStarter {
    public static void main(String[] args) {
        SpringApplication.run(InterfaceStarter.class, args);
    }
}

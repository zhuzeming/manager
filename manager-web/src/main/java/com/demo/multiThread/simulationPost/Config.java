package com.demo.multiThread.simulationPost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZeMing Zhu
 * @date Create in 2020/12/21 11:13
 * @description 请添加描述
 */
@Configuration
public class Config {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

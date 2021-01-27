package com.demo.multiThread.simulationPost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZeMing Zhu
 * @description 模拟十个请求并发同时提交
 * @date Create in 2020/12/21 9:25
 */
@Component
public class Test implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
    private static final int threadPoolSize = 10;

    private RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("==============执行多线程测试======================");
        String url = "http://localhost:8000/";
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            String userId = "userId" + i;
            HttpEntity httpEntity = buildRequest(userId);
            executorService.submit(() -> {
                try {
                    countDownLatch.await();
                    System.out.println("Thread:" + Thread.currentThread().getName() + ",time:" + System.currentTimeMillis());
                    ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, restTemplate, String.class);
                    System.out.println("Thread:" + Thread.currentThread().getName() + "," + responseEntity.getBody());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.countDown();
    }

    private HttpEntity buildRequest(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "yourToken");
        Map<String, Object> body = new HashMap<>(16);
        body.put("userId", userId);
        return new HttpEntity(body, headers);
    }
}

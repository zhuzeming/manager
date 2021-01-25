package com.demo;

import static org.junit.Assert.assertTrue;

import com.demo.dao.UserMapper;
import com.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootStarter.class})
public class AppTest {

    @Resource
    UserMapper mapper;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        User user = mapper.sel(1);
        String str = mapper.sel2();
        System.out.println(user);
        assertTrue( str.equals("123"));
    }
}

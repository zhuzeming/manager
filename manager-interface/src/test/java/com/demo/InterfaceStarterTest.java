package com.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.demo.dao.UserMapper;
import com.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InterfaceStarter.class)
public class InterfaceStarterTest {
    @Autowired
    UserMapper userMapper;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertNotNull(userMapper);
        System.out.println(userMapper.sel(2));
    }
}

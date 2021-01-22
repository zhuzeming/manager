package com.demo.service.impl;

import com.demo.pojo.User;
import com.demo.dao.UserMapper;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/20 14:25
 * @description 请添加描述
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User sel(int id){
        return userMapper.sel(id);
    }

    @Override
    public String test() {
        return userMapper.sel2();
    }

}

package com.demo.dao;

import com.demo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/20 13:13
 * @description 请添加描述
 */
@Repository
public interface UserMapper {
        /**
         * sel
         * @param id
         * @return
         */
        User sel(int id);
        String sel2();
}

package com.demo.mapper;

import com.demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ZeMing Zhu
 * @date Create in 2021/1/20 13:13
 * @description 请添加描述
 */
@Repository
public interface UserMapping {
        /**
         * sel
         * @param id
         * @return
         */
        User sel(int id);
}

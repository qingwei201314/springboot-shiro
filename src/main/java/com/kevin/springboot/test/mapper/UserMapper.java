package com.kevin.springboot.test.mapper;

import com.kevin.springboot.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  {
        User selectUser(Integer id);
        User getByUsername(String username);
}

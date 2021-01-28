package com.kevin.springboot.test.dao;

import com.kevin.springboot.test.entity.User;
import com.kevin.springboot.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public User selectUserById(Integer id) {
        return userMapper.selectUser(id);
    }
}

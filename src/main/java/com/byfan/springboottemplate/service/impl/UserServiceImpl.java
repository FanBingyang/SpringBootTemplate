package com.byfan.springboottemplate.service.impl;

import com.byfan.springboottemplate.model.UserEntity;
import com.byfan.springboottemplate.jpa.UserJap;
import com.byfan.springboottemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: FBY
 * @Description
 * @Version 1.0
 * @Date: 2021/7/25 23:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJap userJap;

    /**
     * 新增/修改用户信息
     * @param user
     * @return
     */
    @Override
    public UserEntity save(UserEntity user) {
        return userJap.save(user);
    }

    @Override
    public List<UserEntity> getAll() {
        return userJap.findAll();
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Override
    public UserEntity getById(Long id) {
        Optional<UserEntity> optional = userJap.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}

package com.byfan.springboottemplate.service;

import com.byfan.springboottemplate.exception.SpringBootTemplateException;
import com.byfan.springboottemplate.model.UserEntity;

import java.util.List;

/**
 * @Author: FBY
 * @Description
 * @Version 1.0
 * @Date: 2021/7/25 23:28
 */
public interface UserService {

    UserEntity save(UserEntity user) throws SpringBootTemplateException;

    List<UserEntity> getAll() throws SpringBootTemplateException;

    UserEntity getById(Long id) throws SpringBootTemplateException;
}

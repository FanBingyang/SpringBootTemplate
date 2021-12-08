package com.byfan.springboottemplate.service.impl;

import com.byfan.springboottemplate.common.CommonResponse;
import com.byfan.springboottemplate.exception.SpringBootTemplateException;
import com.byfan.springboottemplate.model.UserEntity;
import com.byfan.springboottemplate.dao.UserJap;
import com.byfan.springboottemplate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
@Slf4j
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
    public UserEntity save(UserEntity user) throws SpringBootTemplateException {
        if (StringUtils.isEmpty(user.getName())){
            log.error("save userName is null");
            throw new SpringBootTemplateException("userName is null",CommonResponse.PARAM_ERROR);
        }
        return userJap.save(user);
    }

    @Override
    public List<UserEntity> getAll() throws SpringBootTemplateException {
        return userJap.findAll();
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Override
    public UserEntity getById(Long id) throws SpringBootTemplateException {
        if (id == null){
            log.error("getById id is null");
            throw new SpringBootTemplateException("id is null",CommonResponse.PARAM_ERROR);
        }
        Optional<UserEntity> optional = userJap.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}

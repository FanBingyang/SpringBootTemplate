package com.byfan.springboottemplate.controller;

import com.byfan.springboottemplate.bean.ResponseMessage;
import com.byfan.springboottemplate.bean.ResponseMessageUtil;
import com.byfan.springboottemplate.common.CommonResponse;
import com.byfan.springboottemplate.common.ObjectResponse;
import com.byfan.springboottemplate.exception.SpringBootTemplateException;
import com.byfan.springboottemplate.model.UserEntity;
import com.byfan.springboottemplate.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FBY
 * @Description 用户控制层
 * @Version 1.0
 * @Date: 2021/7/25 23:45
 */
@Slf4j
@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增/修改用户信息
     * @param user
     * @return
     */
    @ApiOperation("根据用户id获取用户信息")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ObjectResponse save(UserEntity user) {
        ObjectResponse response = new ObjectResponse();
        try {
            UserEntity u = userService.save(user);
            response.setResult(u);
            response.setCode(CommonResponse.STATUS_OK);
            return response;
        }catch (SpringBootTemplateException e){
            log.error("save is except, e: ",e);
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
            return response;
        }
    }

    /**
     * 获取所有用户
     * @return
     */
    @ApiOperation("根据用户id获取用户信息")
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public ObjectResponse getAll() {
        ObjectResponse response = new ObjectResponse();
        try {
            List<UserEntity> all = userService.getAll();
            response.setResult(all);
            response.setCode(CommonResponse.STATUS_OK);
            return response;
        }catch (SpringBootTemplateException e){
            log.error("getAll is except, e: ",e);
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
            return response;
        }
    }

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @ApiOperation("根据用户id获取用户信息")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public ObjectResponse getById(Long id) {
        ObjectResponse response = new ObjectResponse();
        try {
            UserEntity user = userService.getById(id);
            if (user != null){
                response.setResult(user);
                response.setCode(CommonResponse.STATUS_OK);
            }else {
                response.setCode(CommonResponse.STATUS_OK);
                response.setMessage("用户不存在");
            }
            return response;
        }catch (SpringBootTemplateException e){
            log.error("save is except, e: ",e);
            response.setCode(e.getErrorCode());
            response.setMessage(e.getMessage());
            return response;
        }
    }
}

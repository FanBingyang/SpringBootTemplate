package com.byfan.springboottemplate.controller;

import com.byfan.springboottemplate.bean.ResponseMessage;
import com.byfan.springboottemplate.bean.ResponseMessageUtil;
import com.byfan.springboottemplate.model.UserEntity;
import com.byfan.springboottemplate.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public ResponseMessage save(UserEntity user) {
        userService.save(user);
        return ResponseMessageUtil.success("保存成功");
    }

    /**
     * 获取所有用户
     * @return
     */
    @ApiOperation("根据用户id获取用户信息")
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public ResponseMessage getAll() {
        List<UserEntity> all = userService.getAll();
        return ResponseMessageUtil.success(all);
    }

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @ApiOperation("根据用户id获取用户信息")
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public ResponseMessage getById(Long id) {
        UserEntity user = userService.getById(id);
        if (user != null){
            return ResponseMessageUtil.success(user);
        }
        return ResponseMessageUtil.success("该用户不存在");
    }
}

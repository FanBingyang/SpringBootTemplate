package com.byfan.springboottemplate.controller;

import com.byfan.springboottemplate.common.CommonResponse;
import com.byfan.springboottemplate.common.BaseResponse;
import com.byfan.springboottemplate.exception.SpringBootTemplateException;
import com.byfan.springboottemplate.model.UserEntity;
import com.byfan.springboottemplate.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description 用户控制层
 * @Author: byfan
 * @Date: 2022/03/07 23:30
 */
@Slf4j
@Api(tags = "用户接口")
@RestController
@RequestMapping("/api/user")public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 新增/保存
	 * @param user
	 * @return 
	 */
	@ApiOperation("根据用户的id获取用户信息")
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public BaseResponse<UserEntity> save(UserEntity user) {
		BaseResponse<UserEntity> response = new BaseResponse();
		try {
			UserEntity u = userService.save(user);
			response.setData(u);
			response.setCode(CommonResponse.OK.code);
			return response;
		} catch (SpringBootTemplateException e) {
			log.error("save is except ,e: ", e);
			response.setCode(e.getErrorCode());
			response.setMsg(e.getMessage());
			return response;
		}
	}

	/**
	 * 查询全部
	 * @return 
	 */
	@ApiOperation("查询全部用户信息")
	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public BaseResponse<List<UserEntity>> getAll() {
		BaseResponse<List<UserEntity>> response = new BaseResponse();
		try {
			List<UserEntity> all = userService.getAll();
			response.setData(all);
			response.setCode(CommonResponse.OK.code);
			return response;
		} catch (SpringBootTemplateException e) {
			log.error("getAll is except ,e: ", e);
			response.setCode(e.getErrorCode());
			response.setMsg(e.getMessage());
			return response;
		}
	}

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return 
	 */
	@ApiOperation("根据id查询用户信息")
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	public BaseResponse<UserEntity> getById(Long id) {
		BaseResponse<UserEntity> response = new BaseResponse();
		try {
			UserEntity user = userService.getById(id);
			response.setData(user);
			response.setCode(CommonResponse.OK.code);
			return response;
		} catch (SpringBootTemplateException e) {
			log.error("getById is except ,e: ", e);
			response.setCode(e.getErrorCode());
			response.setMsg(e.getMessage());
			return response;
		}
	}

}
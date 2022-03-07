package com.byfan.springboottemplate.dao;

import com.byfan.springboottemplate.model.UserEntity;

/**
 * @Author: FBY
 * @Description 用户持久层
 * @Version 1.0
 * @Date: 2021/7/25 23:27
 */
public interface UserDao extends BaseRepository<UserEntity,Long> {
}

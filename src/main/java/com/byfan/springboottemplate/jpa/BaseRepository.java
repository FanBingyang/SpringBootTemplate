package com.byfan.springboottemplate.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @Author: FBY
 * @Description 基础Dao类
 * @Version 1.0
 * @Date: 2021/7/25 23:24
 */

@NoRepositoryBean
public interface BaseRepository<T,PK extends Serializable> extends JpaRepository<T,PK> {
}

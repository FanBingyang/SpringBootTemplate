package com.byfan.springboottemplate.model;

/**
 * @Author: FBY
 * @Description 用户实体类
 * @Version 1.0
 * @Date: 2021/7/25 23:12
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@ApiModel
@Table(name = "user")
public class UserEntity implements Serializable {

    /**
     * 用户唯一标识
     */
    @ApiModelProperty(value = "用户唯一标识")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "姓名")
    @Column(name = "name")
    private String name;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "性别")
    @Column(name = "gender")
    private String gender;

    /**
     * 用户年龄
     */
    @ApiModelProperty(value = "年龄")
    @Column(name = "age")
    private Integer age;

    /**
     * 用户电话
     */
    @ApiModelProperty(value = "电话")
    @Column(name = "telephone")
    private String telephone;

    /**
     * 用户地址
     */
    @ApiModelProperty(value = "地址")
    @Column(name = "address")
    private String address;

    /**
     * 用户注册时间
     */
    @ApiModelProperty(value = "注册时间")
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间时间")
    @LastModifiedDate
    @Column(name = "update_time")
    private Date updateTime;


}

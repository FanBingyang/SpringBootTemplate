package com.byfan.springboottemplate.exception;

import com.byfan.springboottemplate.common.CommonResponse;

/**
 * @Author: byfan
 * @Description 服务端抛出异常
 * @Version 1.0
 * @Date: 2021/12/8 21:35
 */
public class SpringBootTemplateException extends Exception{

    private Integer errorCode;

    public SpringBootTemplateException(Integer errorCode) {
        super(CommonResponse.STATUS_DEFAULT_MESSAGE.get(errorCode));
        this.errorCode = errorCode;
    }

    public SpringBootTemplateException(String message) {
        super(message);
    }

    public SpringBootTemplateException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}

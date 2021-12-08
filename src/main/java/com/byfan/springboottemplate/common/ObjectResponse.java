package com.byfan.springboottemplate.common;

/**
 * @Author: byfan
 * @Description 后端返回统一对象
 * @Version 1.0
 * @Date: 2021/12/8 21:29
 */
public class ObjectResponse<T> extends CommonResponse{
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ObjectResponse(T result) {
        this.result = result;
    }

    public ObjectResponse() {
    }

    @Override
    public String toString() {
        return "ObjectResponse{" +
                "result=" + result +
                '}';
    }
}

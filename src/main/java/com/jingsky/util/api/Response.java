package com.jingsky.util.api;

import java.io.Serializable;

/**
 * 用于API通用返回对象
 * @param <T> 范型
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private T data;

    public Response success() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
        return this;
    }

    public Response failure() {
        this.code = ResponseCode.ERROR.getCode();
        this.msg = ResponseCode.ERROR.getMsg();
        return this;
    }

    public Response warning() {
        this.code = ResponseCode.WARNING.getCode();
        this.msg = ResponseCode.WARNING.getMsg();
        return this;
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Response setData(T data) {
        this.data = data;
        return this;
    }


    public Response(T data) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
        this.data = data;
    }

    public Response(T data,String message) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = message;
        this.data = data;
    }

    public Response(T data,ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }
}

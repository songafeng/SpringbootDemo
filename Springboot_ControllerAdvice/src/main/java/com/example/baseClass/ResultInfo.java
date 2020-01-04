package com.example.baseClass;


import com.example.enums.ResponseEnum;

import java.io.Serializable;

/**
 * Created by wjd on 2019/4/19.
 */
public class ResultInfo<T> implements Serializable {

    private Integer code;

    private T obj;

    private String msg;

    public ResultInfo(Integer status, T obj, String msg) {
        this.obj = obj;
        this.msg = msg;
        this.code = status;
    }

    public static ResultInfo success(Object obj){
        return new ResultInfo(ResponseEnum.SUCCESS.getValue(), obj, ResponseEnum.SUCCESS.getLabel());
    }

    public static ResultInfo fail(String msg, Object obj) {
        return new ResultInfo(ResponseEnum.FAIL.getValue(),obj, msg);
    }

    public static ResultInfo error(Integer status, String msg, Object obj) {
        return new ResultInfo(status, obj, msg);
    }

    public ResultInfo() {

    }

    public Integer getStatus() {
        return code;
    }

    public void setStatus(Integer status) {
        this.code = status;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


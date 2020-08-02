package com.tftte.bean;

/**
 * @Author: tftte
 * @Date: 2020/8/2 11:41
 * @Description:
 */
public class AjaxResponseInfo<T> {
    private int code;  // 0 正常，其他不正常
    private String msg;  // 提示信息
    private T data;  // 数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

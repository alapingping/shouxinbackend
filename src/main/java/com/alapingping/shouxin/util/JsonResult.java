package com.alapingping.shouxin.util;

import java.util.List;

public class JsonResult<T> {

    private T data;
    private List<T> datas;
    private int code;
    private String msg;

    public JsonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(List<T> datas, int code, String msg) {
        this.datas = datas;
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}

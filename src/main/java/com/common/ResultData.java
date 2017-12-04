package com.common;

/**
 * Created by 黎 on 2017/11/30.
 */
public class ResultData {

    private String msg;

    private Integer code;

    private Object Date;

    public static final Integer CODE_SUCCESS = 1 ;
    public static final Integer CODE_FAILED = 9999 ;
    public static final String MSG_SUCCESS = "成功";
    public static final String MSG_FAILED = "失败";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getDate() {
        return Date;
    }

    public void setDate(Object date) {
        Date = date;
    }
}

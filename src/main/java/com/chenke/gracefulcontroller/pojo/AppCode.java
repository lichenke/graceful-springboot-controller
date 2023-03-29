package com.chenke.gracefulcontroller.pojo;

/**
 * @author LiChenke
 **/
public enum AppCode implements StatusCode {

    APP_ERROR(1000, "业务异常"),
    ID_ERROR(1001, "id有误"),
    NAME_ERROR(1002, "name有误");


    private final int code;
    private final String msg;

    AppCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

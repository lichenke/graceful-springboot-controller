package com.chenke.gracefulcontroller.exception;

import com.chenke.gracefulcontroller.pojo.StatusCode;

/**
 * @author LiChenke
 **/
public class AppException extends RuntimeException {

    private final int code;
    private final String msg;

    public AppException(String message, StatusCode code) {
        super(message);
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

package com.chenke.gracefulcontroller.pojo;

import static com.chenke.gracefulcontroller.pojo.ResultCode.SUCCESS;

/**
 * @author LiChenke
 **/
public class ResultVo<T> {

    private int code;

    private String msg;

    private T result;

    public ResultVo(int code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public ResultVo(T result) {
        this.code = SUCCESS.getCode();
        this.msg = SUCCESS.getMsg();
        this.result = result;
    }

    public ResultVo(StatusCode code, T result) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.result = result;
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

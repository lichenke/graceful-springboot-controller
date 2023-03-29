package com.chenke.gracefulcontroller.controller.advice;

import static com.chenke.gracefulcontroller.pojo.ResultCode.VALIDATE_ERROR;

import com.chenke.gracefulcontroller.exception.AppException;
import com.chenke.gracefulcontroller.pojo.ResultVo;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LiChenke
 **/

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResultVo<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVo<>(VALIDATE_ERROR, objectError.getDefaultMessage());
    }

    @ExceptionHandler({AppException.class})
    public ResultVo<?> AppExceptionHandler_(AppException e) {
        return new ResultVo<>(e.getCode(), e.getMsg(), e.getMessage());
    }

}

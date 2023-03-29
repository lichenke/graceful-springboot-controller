package com.chenke.gracefulcontroller.controller.advice;

import com.chenke.gracefulcontroller.annotation.ExcludeControllerResponseAdvice;
import com.chenke.gracefulcontroller.pojo.ResultVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author LiChenke
 **/
@RestControllerAdvice(basePackages = {"com.chenke.gracefulcontroller.controller"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    // 重写supports方法，也就是说，当返回类型已经是ResultVo了，那就不需要封装了
    // 当不等与ResultVo时才进行调用beforeBodyWrite方法，跟过滤器的效果是一样的。
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        // response是ResultVo类型，或者注解了ExcludeControllerResponseAdvice的接口都不进行包装
        return !(methodParameter.getParameterType().isAssignableFrom(ResultVo.class)
                || methodParameter.hasMethodAnnotation(ExcludeControllerResponseAdvice.class));
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            serverHttpResponse.getHeaders().set("Content-Type", "application/json");
            try {
                return objectMapper.writeValueAsString(new ResultVo<>(o));
            } catch (JsonProcessingException e) {
                throw new IllegalStateException(e);
            }
        }
        return new ResultVo<>(o);
    }
}

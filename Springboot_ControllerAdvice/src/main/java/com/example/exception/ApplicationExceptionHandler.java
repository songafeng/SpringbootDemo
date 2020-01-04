package com.example.exception;

import com.example.baseClass.ResultInfo;
import com.example.enums.ResponseEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by wjd on 2019/4/19.
 */
//@EnableWebMvc
@ControllerAdvice
public class ApplicationExceptionHandler {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public <T> ResultInfo<T> handlerError(HttpServletRequest request, Exception e) throws Exception {
        if (e instanceof ServiceException) {
            return ResultInfo.fail(e.getMessage(), null);
        }else{
            return ResultInfo.fail(ResponseEnum.FAIL.getLabel(), null);
        }
    }
}

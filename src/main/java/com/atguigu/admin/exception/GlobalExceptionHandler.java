package com.atguigu.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description
 * @date 2023/4/5 0005 20:33
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleException(Exception e){
        log.info("异常是：" + e);
        return "login";
    }
}

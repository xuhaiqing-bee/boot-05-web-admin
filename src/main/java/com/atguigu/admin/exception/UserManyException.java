package com.atguigu.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description   自定义异常
 * @date 2023/4/5 0005 20:45
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "人数太多")
public class UserManyException extends RuntimeException{

    public UserManyException() {
    }

    public UserManyException(String message) {
        super(message);
    }
}

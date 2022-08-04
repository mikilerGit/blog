package com.xupt.common.handler.exception;

import com.xupt.common.domain.ResponseResult;
import com.xupt.common.enums.HttpEnum;
import com.xupt.common.exeception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 处理 SystemException 自定义异常

    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e) {

        //打印异常信息
        log.error("出现了自定义异常！ {}", e);

        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult().code(e.getCode()).msg(e.getMsg());
    }

    // 不可能自定义完所有的异常，

    // 处理 除了抛出的SystemException之外的 异常

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e) {

        //打印异常信息
        log.error("出现了系统异常！ {}", e);

        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult().msg(e.getMessage());

    }
}

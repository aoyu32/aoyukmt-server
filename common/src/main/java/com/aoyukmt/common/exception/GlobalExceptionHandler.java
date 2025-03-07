package com.aoyukmt.common.exception;

import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName：GobalExceptionHandler
 * @Author: aoyu
 * @Date: 2025-03-07 22:54
 * @Description: 全局异常处理类
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        System.out.println(e.getMessage());
        return Result.error(ResultCode.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException e) {
        System.out.println(e.getMessage());
        return Result.error(e.getCode(),e.getMsg(),null);
    }


}

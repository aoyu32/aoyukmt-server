package com.aoyukmt.common.exception;

import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.result.Result;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName：GobalExceptionHandler
 * @Author: aoyu
 * @Date: 2025-03-07 22:54
 * @Description: 全局异常处理类
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理其他所有未预期的异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        log.error("系统异常: {}", e);
        return Result.error(ResultCode.SYSTEM_ERROR);
    }

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException e) {
        log.error("业务异常: code={}, message={}", e.getCode(), e.getMessage());
        return Result.error(e.getCode(), e.getMessage());
    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Result<Map<String,String>> handleValidationException(MethodArgumentNotValidException e) {
//        log.info("数据校验异常：{}",e.getMessage());
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        Map<String, String> errorMap = new HashMap<>();
//        fieldErrors.forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
//        return Result.error(ResultCode.PARAM_ERROR,errorMap);
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Result<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
//        log.info("参数校验异常：{}", e.getMessage());
//        Map<String, String> errorMap = new HashMap<>();
//        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
//            String field = violation.getPropertyPath().toString(); // 获取字段路径
//            String message = violation.getMessage();
//            errorMap.put(field, message);
//        }
//        return Result.error(ResultCode.PARAM_ERROR, errorMap);
//    }


    /**
     * 处理数据校验异常
     * @param e 异常
     * @return 错误result
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public Result<Map<String, String>> handleValidationExceptions(Exception e) {
        log.info("参数校验异常：{}", e.getMessage());
        Map<String, String> errorMap = new HashMap<>();

        if (e instanceof MethodArgumentNotValidException) {
            // 处理 @RequestBody 和 @RequestParam 的参数校验异常
            List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
            fieldErrors.forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));

        } else if (e instanceof ConstraintViolationException) {
            // 处理 @PathVariable 的参数校验异常
            for (ConstraintViolation<?> violation : ((ConstraintViolationException) e).getConstraintViolations()) {
                String field = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                errorMap.put(field, message);
            }
        }

        return Result.error(ResultCode.PARAM_ERROR, errorMap);
    }


}

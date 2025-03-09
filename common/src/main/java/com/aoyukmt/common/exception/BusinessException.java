package com.aoyukmt.common.exception;

import com.aoyukmt.common.enumeration.ResultCode;
import lombok.Data;

/**
 * @ClassName：BussinessException
 * @Author: aoyu
 * @Date: 2025-03-07 22:58
 * @Description: 业务异常处理类
 */

@Data
public class BusinessException extends RuntimeException{

    private Integer code;
    private String msg;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}

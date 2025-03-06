package com.aoyukmt.common.result;

import com.aoyukmt.common.enumeration.ResultCode;
import lombok.Data;

/**
 * @ClassName：Result
 * @Author: aoyu
 * @Date: 2025-03-06 16:01
 * @Description: 统一返回结果类
 */
@Data
public class Result<T> {

    private int code;//状态码,200成功，500失败
    private String msg;//状态说明
    private T data;//数据

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //成功，无数据返回
    public static <T> Result<T> success() {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
    }

    //成功，有数据返回
    public static <T> Result<T> success(T data) {
        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    //失败
    public static <T> Result<T> error(ResultCode resultCode) {
        return new Result(resultCode.getCode(), resultCode.getMsg(), null);
    }

}

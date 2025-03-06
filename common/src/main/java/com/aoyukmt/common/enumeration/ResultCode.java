package com.aoyukmt.common.enumeration;

import lombok.Getter;

//响应状态码枚举类
public enum ResultCode {

    SUCCESS(200, "成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");


    @Getter
    private final int code;
    @Getter
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

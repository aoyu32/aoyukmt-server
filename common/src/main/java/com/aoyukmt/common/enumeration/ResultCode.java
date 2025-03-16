package com.aoyukmt.common.enumeration;

import lombok.Getter;

//响应状态码枚举类
public enum ResultCode {

    /* 成功 */
    SUCCESS(200, "操作成功"),

    /* 客户端错误 */
    BAD_REQUEST(400, "错误的请求"),
    PARAM_ERROR(400, "参数不合法"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    NOT_ACCEPTABLE(406, "不可接受的请求"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "资源冲突"),
    GONE(410, "资源已删除"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),
    TOO_MANY_REQUESTS(429, "请求过于频繁"),

    /* 服务器错误 */
    SYSTEM_ERROR(500, "系统内部错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    DB_ERROR(504, "数据库错误"),

    /*业务错误*/
    /**文件上传**/
    UPLOAD_IMG_MAX(430,"上传资源过大"),
    OSS_EXCEPTION(431,"OSS异常"),

    /**下载**/
    RESOURCES_NOT_EXITS(432,"安装包不存在"),
    INVALID_FILENAME(433,"非法的文件名"),
    DOWNLOAD_FAILED(434,"文件下载出错"),
    UNKNOWN_VERSION_TYPE(435,"未知版本类型"),
    NOT_OFFICIAL_DOWNLOAD(436,"非官网下载");

    @Getter
    private final int code;
    @Getter
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

package com.aoyukmt.common.enumeration;

import lombok.Getter;

//响应状态码枚举类
public enum ResultCode {

    /* 成功 */
    SUCCESS(200, "操作成功"),
    /*失败*/
    ERROR(300, "操作失败"),

    /* 客户端错误 */
    PARAM_ERROR(401, "参数不合法"),
    TOO_MANY_REQUESTS(429, "请求过于频繁"),

    /* 服务器错误 */
    SYSTEM_ERROR(500, "服务器繁忙"),

    /*业务错误*/
    /**
     * 文件上传
     **/
    UPLOAD_IMG_MAX(430, "上传资源过大"),
    OSS_EXCEPTION(431, "OSS异常"),

    /**
     * 下载
     **/
    RESOURCES_NOT_EXITS(432, "安装包不存在"),
    INVALID_FILENAME(433, "非法的文件名"),
    DOWNLOAD_FAILED(434, "文件下载出错"),
    UNKNOWN_VERSION_TYPE(435, "未知版本类型"),
    LINK_BROKEN(436, "失效的链接"),

    /**
     * 验证码异常
     */
    VERIFY_CODE_ERROR(437, "验证码验证异常"),

    /**
     * 用户注册
     */
    USER_ALREADY_EXIST(438, "用户已存在"),

    /**
     * 用户登录
     */
    USER_NOT_EXIST(439, "用户不存在"),

    /**
     * 账号或密码错误
     */
    ACCOUNT_OR_PASSWORD_ERROR(440, "账号或密码错误"),
    PASSWORD_ERROR(440,"密码错误"),

    /**
     * token过期
     */
    TOKEN_EXPIRED(441, "token过期"),

    /**
     * 无效的token
     */
    TOKEN_VALIDATE_FAIL(442, "无效的token"),

    /**
     * 未登录
     */
    UN_LOGIN(443, "未登录"),

    /**
     * 不支持的文件类型
     */
    UNSUPPORTED_FILE_TYPE(444,"不支持的文件类型"),

    /**
     * 资源过期
     */
    RANDOM_AVATAR_EXPIRED(445,"头像资源过期,请重新生成"),

    /**
     * 验证码失效
     */
    EMAIL_CODE_EXPIRED(446,"邮箱验证码已失效"),

    /**
     * 验证码错误
     */
    EMAIL_CODE_ERROR(447,"验证码错误"),

    /**
     * 邮箱已经被绑定
     */
    EMAIL_HAS_BINDING(448,"邮箱已被绑定"),

    /**
     * 未知的反馈类型
     */
    UNKNOWN_FEEDBACK_TYPE(449,"未知的反馈类型"),

    /**
     * 邮箱不存在
     */
    UNKNOWN_EMAIL_ACCOUNT(450,"未查到该邮箱所绑定的账号"),

    /**
     * 未知验证码服务类型
     */
    UNKNOWN_EMAIL_CODE_SERVICE(451,"未知验证码服务类型");

    @Getter
    private final int code;
    @Getter
    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

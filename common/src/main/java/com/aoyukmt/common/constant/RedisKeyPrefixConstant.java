package com.aoyukmt.common.constant;

/**
 * @ClassName：RedisKeyPrefixConstant
 * @Author: aoyu
 * @Date: 2025-03-12 22:19
 * @Description: redis的key的前缀常量
 */

public class RedisKeyPrefixConstant {

    //请求限制key前缀
    public static final String RATE_LIMIT = "rate_limit:";

    //唯一下载id的key前缀
    public static  final String DOWNLOAD_ID = "download_id:";

    //用户生成的随机头像key前缀
    public static  final String USER_RANDOM_AVATAR = "user_random_avatar:";

    //绑定邮箱验证码前缀
    public static  final String VERIFY_CODE_EMAIL_BINDING = "verify_code_binding:";

    //重置密码邮箱验证码前缀
    public static  final String EMAIL_VERIFY_RESET_CODE = "verify_code_reset:";

}

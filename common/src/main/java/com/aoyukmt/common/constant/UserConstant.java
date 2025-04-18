package com.aoyukmt.common.constant;

import java.util.Set;

/**
 * @ClassName：UserConstant
 * @Author: aoyu
 * @Date: 2025-04-16 20:53
 * @Description: 用户相关的常量
 */

public class UserConstant {


    /**
     * 随机用户名前缀
     */
    public static final String RANDOM_USERNAME_PREFIX = "akm-";

    /**
     * 随机字符池
     */
    public static final String CHAR_POOL = "abcdefghijklmnopqrstuvwxyz1234567890";

    /**
     * 注销用户名后缀
     */
    public static final String USER_DELETE = "_#delete";

    /**
     * 用户上次的头像最大size
     */
    public static final Integer MAX_AVATAR_IMAGE_FILE_SIZE = 1024 * 1024 * 3;

    /**
     * 用户头像oss文件夹路径
     */
    public static final String ALI_OSS_USER_AVATAR_DIR_PATH = "img/user/avatar/";

    /**
     * 支持的头像图片类型
     */
    public static final Set<String> FILE_TYPE = Set.of("image/jpeg", "image/png", "image/jpg");

    /**
     * 用户操作随机头像的行为
     */
    public static final String USER_CONFIRM_RANDOM_AVATAR_ACTION = "confirm";
    public static final String USER_GENERATE_RANDOM_AVATAR_ACTION = "generate";

}

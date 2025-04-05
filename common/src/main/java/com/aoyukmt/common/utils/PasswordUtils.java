package com.aoyukmt.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName：PasswordUtils
 * @Author: aoyu
 * @Date: 2025-04-05 20:36
 * @Description: 密码加密解密
 */

public class PasswordUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 加密原始密码
    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    // 验证密码是否匹配
    public static boolean match(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

}

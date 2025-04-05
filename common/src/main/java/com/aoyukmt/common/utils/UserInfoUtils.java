package com.aoyukmt.common.utils;

import java.util.Random;

/**
 * @ClassName：UserInfoUtils
 * @Author: aoyu
 * @Date: 2025-04-05 20:47
 * @Description: 用户信息信息生成工具类
 */

import java.util.*;

public class UserInfoUtils {

    private final static String usernamePrefix = "akm-";
    private final static String CHAR_POOL = "abcdefghijklmnopqrstuvwxyz1234567890";

    //随机颜色值
    private final static List<String> BACKGROUND_COLORS = Arrays.asList(
            "FFB6C1", "FFE4E1", "E6E6FA", "F0FFF0", "F0F8FF",  // 浅色系
            "87CEEB", "98FB98", "DDA0DD", "F0E68C", "E0FFFF",  // 中色系
            "FFA07A", "7FFFD4", "FFDAB9", "D8BFD8", "B0E0E6"   // 暖色系
    );

    private final static Map<String,List<String>> STYLES = new HashMap<>();



    /**
     * 生成随机昵称
     */
    public static String getRandomNickname() {
        StringBuilder nickname = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            nickname.append(CHAR_POOL.charAt(index));
        }

        return usernamePrefix + nickname;
    }

}
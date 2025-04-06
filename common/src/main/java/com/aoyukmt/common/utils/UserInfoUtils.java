package com.aoyukmt.common.utils;

import java.util.Random;

public class UserInfoUtils {

    private final static String usernamePrefix = "akm-";
    private final static String CHAR_POOL = "abcdefghijklmnopqrstuvwxyz1234567890";

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
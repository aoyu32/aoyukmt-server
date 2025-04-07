package com.aoyukmt.common.utils;

import jakarta.servlet.http.HttpServletRequest;

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

    /**
     * 获取客户端真实 IP 地址
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 如果是多级代理，取第一个 IP
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }

        return ip;
    }

}
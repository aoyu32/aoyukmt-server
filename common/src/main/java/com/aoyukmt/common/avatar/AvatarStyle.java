package com.aoyukmt.common.avatar;

/**
 * @ClassName：AvatarStyle
 * @Author: aoyu
 * @Date: 2025-04-06 18:18
 * @Description: 头像风格抽象类
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 头像风格的抽象基类
 */
public abstract class AvatarStyle {
    protected static final String BASE_URL = "https://api.dicebear.com/9.x/";
    protected static final Random random = new Random();

    // 固定的尺寸、形状和圆角参数
    protected static final Integer DEFAULT_SIZE = 128;
    protected static final String DEFAULT_RADIUS = "0";  // 50%圆角半径，可以根据需要调整

    // 共有参数
    protected final String seed;
    protected final String backgroundColor;
    protected final Integer size;
    protected final String radius;

    public AvatarStyle() {
        // 随机种子
        this.seed = generateRandomString(8);

        // 使用随机背景色
        this.backgroundColor = random.nextBoolean() ? getRandomColor() : null;

        // 固定尺寸和形状参数
        this.size = DEFAULT_SIZE;  // 固定大小
        this.radius = DEFAULT_RADIUS;  // 固定圆角
    }

    /**
     * 构建URL的方法，由子类实现具体风格的参数设置
     */
    public abstract String buildUrl();

    /**
     * 添加通用参数到URL
     */
    protected String addCommonParams(String url) {
        Map<String, String> params = new HashMap<>();
        // 始终添加固定的大小和圆角
        params.put("size", size.toString());
        params.put("radius", radius);
        // 其他可选参数
        if (backgroundColor != null) params.put("backgroundColor", backgroundColor);
        // 参数转换为URL查询字符串
        if (!params.isEmpty()) {
            String queryString = params.entrySet().stream()
                    .map(e -> e.getKey() + "=" + e.getValue())
                    .collect(Collectors.joining("&"));
            return url + (url.contains("?") ? "&" : "?") + queryString;
        }
        return url;
    }

    // 生成随机字符串作为种子
    protected static String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // 生成随机颜色
    // 生成随机颜色 - 修改版
    protected static String getRandomColor() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append("0123456789ABCDEF".charAt(random.nextInt(16)));
        }
        return sb.toString();  // 不再添加"#"前缀
    }

    // 从列表中随机选择一个值
    protected static <T> T randomChoice(List<T> options) {
        return options.get(random.nextInt(options.size()));
    }

    // 随机布尔值作为字符串
    protected static String randomBoolean() {
        return random.nextBoolean() ? "true" : "false";
    }
}
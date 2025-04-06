package com.aoyukmt.common.avatar;

/**
 * @ClassName：DiceBearAvatarGenerator
 * @Author: aoyu
 * @Date: 2025-04-06 18:24
 * @Description: 随机头像生成器
 */

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * DiceBear随机头像生成器
 * 基于DiceBear的HTTP API设计
 */
public class DiceBearAvatarGenerator {

    private static final Random random = new Random();

    /**
     * 生成随机头像URL
     * @return 随机头像的URL
     */
    public static String generateRandomAvatarUrl() {
        List<AvatarStyle> styles = Arrays.asList(
                new LoreleiStyle(),
                new PixelArtStyle(),
                new AdventurerStyle(),
                new BotttsStyle()
        );

        // 随机选择一个风格
        AvatarStyle style = styles.get(random.nextInt(styles.size()));

        return style.buildUrl();
    }
}
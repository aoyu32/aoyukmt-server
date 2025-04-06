package com.aoyukmt.common.avatar;

/**
 * @ClassName：LoreleiStyle
 * @Author: aoyu
 * @Date: 2025-04-06 18:21
 * @Description: lorrlei风格头像
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Lorelei 风格头像
 */
public class LoreleiStyle extends AvatarStyle {
    private final String earrings;
    private final String eyebrows;
    private final String eyes;
    private final String glasses;
    private final String mouth;
    private final String hair;
    private final String hairColor;

    public LoreleiStyle() {
        super();
        // Lorelei特有属性
        List<String> earringsOptions = Arrays.asList("variant01", "variant02", "variant03");
        this.earrings = random.nextBoolean() ? randomChoice(earringsOptions) : null;

        List<String> eyebrowsOptions = Arrays.asList("variant01", "variant02", "variant03", "variant04", "variant05", "variant06");
        this.eyebrows = random.nextBoolean() ? randomChoice(eyebrowsOptions) : null;

        List<String> eyesOptions = Arrays.asList("variant01", "variant02", "variant03", "variant04", "variant05", "variant06");
        this.eyes = random.nextBoolean() ? randomChoice(eyesOptions) : null;

        List<String> glassesOptions = Arrays.asList("variant01", "variant02", "variant03", "variant04", "variant05");
        this.glasses = random.nextBoolean() ? randomChoice(glassesOptions) : null;

        List<String> mouthOptions = Arrays.asList("happy01", "happy02", "happy03", "happy04", "happy05","sad01", "sad02", "sad03");
        this.mouth = random.nextBoolean() ? randomChoice(mouthOptions) : null;

        List<String> hairOptions = Arrays.asList("variant01", "variant02", "variant03", "variant04", "variant05", "variant06");
        this.hair = random.nextBoolean() ? randomChoice(hairOptions) : null;

        this.hairColor = random.nextBoolean() ? getRandomColor() : null;
    }

    @Override
    public String buildUrl() {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append("lorelei/svg?seed=").append(seed);

        Map<String, String> styleParams = new HashMap<>();
        if (earrings != null) styleParams.put("earrings", earrings);
        if (eyebrows != null) styleParams.put("eyebrows", eyebrows);
        if (eyes != null) styleParams.put("eyes", eyes);
        if (glasses != null) styleParams.put("glasses", glasses);
        if (mouth != null) styleParams.put("mouth", mouth);
        if(hair!= null) styleParams.put("hair", hair);
        if (hairColor!= null) styleParams.put("hairColor", hairColor);

        // 添加特有参数
        for (Map.Entry<String, String> entry : styleParams.entrySet()) {
            urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }

        // 添加通用参数
        return addCommonParams(urlBuilder.toString());
    }
}

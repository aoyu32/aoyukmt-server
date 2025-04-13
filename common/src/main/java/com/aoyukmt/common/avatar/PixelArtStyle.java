package com.aoyukmt.common.avatar;

/**
 * @ClassName：PixelArtStyle
 * @Author: aoyu
 * @Date: 2025-04-06 18:22
 * @Description: PixelArt 风格头像
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PixelArt 风格头像
 */
public class PixelArtStyle extends AvatarStyle {
    private final String beard;
    private final String glasses;
    private final String hair;
    private final String mouth;
    private final String skinColor;

    public PixelArtStyle() {
        super();

        List<String> beardOptions = Arrays.asList("variant01", "variant02", "variant03", "variant04", "variant05", "variant06");
        this.beard = random.nextBoolean() ? randomChoice(beardOptions) : null;

        List<String> glassesOptions = Arrays.asList("dark01", "dark02", "dark03", "dark04", "dark05","light01", "light02", "light03", "light04", "light05", "light06");
        this.glasses = random.nextBoolean() ? randomChoice(glassesOptions) : null;

        List<String> hairOptions = Arrays.asList("long01", "long02", "long03", "long04","short01", "short02", "short03", "short04");
        this.hair = random.nextBoolean() ? randomChoice(hairOptions) : null;


        List<String> mouthOptions = Arrays.asList("happy01", "happy02", "happy03", "happy04","sad01","sad02","sad03","sad04","sad05");
        this.mouth = random.nextBoolean() ? randomChoice(mouthOptions) : null;


        this.skinColor = random.nextBoolean() ? getRandomColor() : null;
    }

    @Override
    public String buildUrl() {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append("pixel-art/svg?seed=").append(seed);

        Map<String, String> styleParams = new HashMap<>();
        if (beard != null) styleParams.put("beard", beard);
        if (glasses != null) styleParams.put("glasses", glasses);
        if (hair != null) styleParams.put("hair", hair);
        if (mouth != null) styleParams.put("mouth", mouth);
        if (skinColor != null) styleParams.put("skinColor", skinColor);

        // 添加特有参数
        for (Map.Entry<String, String> entry : styleParams.entrySet()) {
            urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }

        // 添加通用参数
        return addCommonParams(urlBuilder.toString());
    }
}
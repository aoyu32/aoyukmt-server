package com.aoyukmt.common.avatar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bottts 风格头像
 */
public class BotttsStyle extends AvatarStyle {
    private final String eyes;
    private final String mouth;
    private final String sides;
    private final String texture;
    private final String top;
    private final String baseColor;
    private final String face;

    public BotttsStyle() {
        super();

        List<String> eyesOptions = Arrays.asList("bulging", "dizzy", "eva", "frame1", "frame2", "glow", "happy", "hearts", "robocop", "round", "roundFrame01", "roundFrame02", "sensor", "shade01");
        this.eyes = random.nextBoolean() ? randomChoice(eyesOptions) : null;

        List<String> mouthOptions = Arrays.asList("bite", "diagram", "grill01", "grill02", "grill03", "smile01", "smile02", "square01", "square02");
        this.mouth = random.nextBoolean() ? randomChoice(mouthOptions) : null;

        List<String> sidesOptions = Arrays.asList("antenna01", "antenna02", "cables01", "cables02", "round", "square", "squareAssymetric");
        this.sides = random.nextBoolean() ? randomChoice(sidesOptions) : null;

        List<String> textureOptions = Arrays.asList("camo01", "camo02", "circuits", "dirty01", "dirty02", "dots", "grunge01", "grunge02");
        this.texture = random.nextBoolean() ? randomChoice(textureOptions) : null;

        List<String> topOptions = Arrays.asList("antenna", "antennaCrooked", "bulb01", "glowingBulb01", "glowingBulb02", "horns", "lights", "pyramid", "radar");
        this.top = random.nextBoolean() ? randomChoice(topOptions) : null;

        List<String> faceOptions = Arrays.asList("round01","round02","square01","square02","square03","square04");
        this.face = random.nextBoolean() ? randomChoice(faceOptions) : null;

        this.baseColor = random.nextBoolean() ? getRandomColor() :null;
    }

    @Override
    public String buildUrl() {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append("bottts/svg?seed=").append(seed);

        Map<String, String> styleParams = new HashMap<>();
        if (eyes != null) styleParams.put("eyes", eyes);
        if (mouth != null) styleParams.put("mouth", mouth);
        if (sides != null) styleParams.put("sides", sides);
        if (texture != null) styleParams.put("texture", texture);
        if (top != null) styleParams.put("top", top);
        if(baseColor!=null) styleParams.put("baseColor", baseColor);
        if (face != null) styleParams.put("face", face);

        // 添加特有参数
        for (Map.Entry<String, String> entry : styleParams.entrySet()) {
            urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }

        // 添加通用参数
        return addCommonParams(urlBuilder.toString());
    }
}
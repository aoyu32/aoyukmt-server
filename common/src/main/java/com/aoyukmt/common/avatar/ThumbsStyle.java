package com.aoyukmt.common.avatar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName：ThumbsStyle
 * @Author: aoyu
 * @Date: 2025-04-15 14:41
 * @Description: ThumbsStyle风格头像
 */

public class ThumbsStyle extends AvatarStyle {
    private final String eyes;
    private final String eyesColor;
    private final String face;
    private final String mouth;
    private final String mouthColor;
    private final String shape;
    private final String shapeColor;
    private final String backgroundType;

    public ThumbsStyle() {
        super();

        List<String> eyesOptions = Arrays.asList(
                "variant1W10", "variant1W12", "variant1W14", "variant1W16",
                "variant2W10", "variant2W12", "variant2W14", "variant2W16",
                "variant3W10", "variant3W12", "variant3W14", "variant3W16",
                "variant4W10", "variant4W12", "variant4W14", "variant4W16"
        );
        this.eyes = random.nextBoolean() ? randomChoice(eyesOptions) : null;

        this.eyesColor = random.nextBoolean() ? getRandomColor() : null;

        List<String> faceOptions = Arrays.asList("variant1", "variant2", "variant3", "variant4", "variant5");
        this.face = random.nextBoolean() ? randomChoice(faceOptions) : null;

        List<String> mouthOptions = Arrays.asList("variant1", "variant2", "variant3", "variant4", "variant5");
        this.mouth = random.nextBoolean() ? randomChoice(mouthOptions) : null;

        this.mouthColor = random.nextBoolean() ? getRandomColor() : null;

        List<String> shapeOptions = Arrays.asList("default");
        this.shape = random.nextBoolean() ? randomChoice(shapeOptions) : null;

        this.shapeColor = random.nextBoolean() ? getRandomColor() : null;

        List<String> backgroundTypeOptions = Arrays.asList("gradientLinear", "solid");
        this.backgroundType = random.nextBoolean() ? randomChoice(backgroundTypeOptions) : null;

    }

    @Override
    public String buildUrl() {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append("thumbs/svg?seed=").append(seed);

        Map<String, String> styleParams = new HashMap<>();
        if (eyes != null) styleParams.put("eyes", eyes);
        if (eyesColor != null) styleParams.put("eyesColor", eyesColor);
        if (face != null) styleParams.put("face", face);
        if (mouth != null) styleParams.put("mouth", mouth);
        if (mouthColor != null) styleParams.put("mouthColor", mouthColor);
        if (shape != null) styleParams.put("shape", shape);
        if (shapeColor != null) styleParams.put("shapeColor", shapeColor);
        if (backgroundType != null) styleParams.put("backgroundType", backgroundType);

        // 添加特有参数
        for (Map.Entry<String, String> entry : styleParams.entrySet()) {
            urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }

        // 添加通用参数
        return addCommonParams(urlBuilder.toString());
    }
}
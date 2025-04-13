package com.aoyukmt.common.avatar;

import java.util.*;

/**
 * @ClassName：NeutralStyle
 * @Author: aoyu
 * @Date: 2025-04-13 18:47
 * @Description: neutral风格头像
 */

public class NeutralStyle extends AvatarStyle{

    private final String eyebrows;
    private final String eyes;
    private final String mouth;
    private final String nose;

    public NeutralStyle() {
        super();
        List<String> eyebrowsOptions = Arrays.asList("angry", "angryNatural", "default", "defaultNatural", "flatNatural", "frownNatural", "raisedExcited", "raisedExcitedNatural", "sadConcerned", "sadConcernedNatural", "unibrowNatural", "upDown", "upDownNatural");
        this.eyebrows = random.nextBoolean() ? randomChoice(eyebrowsOptions) : null;
        List<String> eyesOptions = Arrays.asList("closed", "cry", "default", "eyeRoll", "happy", "hearts", "side", "squint", "surprised", "wink", "winkWacky", "xDizzy");
        this.eyes = random.nextBoolean() ? randomChoice(eyesOptions) : null;
        List<String> mouthOptions = Arrays.asList("concerned", "default", "disbelief", "eating", "grimace", "sad", "screamOpen", "serious", "smile", "tongue", "twinkle");
        this.mouth = random.nextBoolean() ? randomChoice(mouthOptions) : null;
        this.nose = random.nextBoolean() ? "default" : null;
    }


    @Override
    public String buildUrl() {
        StringBuilder urlBuilder = new StringBuilder(BASE_URL);
        urlBuilder.append("avataaars-neutral/svg?seed=").append(seed);
        Map<String, String> styleParams = new HashMap<>();
        if (eyebrows != null) styleParams.put("eyebrows", eyebrows);
        if (eyes != null) styleParams.put("eyes", eyes);
        if(mouth!=null) styleParams.put("mouth", mouth);
        if (nose != null) styleParams.put("nose", nose);

        for (Map.Entry<String,String> entry : styleParams.entrySet()) {
            urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return addCommonParams(urlBuilder.toString());
    }
}

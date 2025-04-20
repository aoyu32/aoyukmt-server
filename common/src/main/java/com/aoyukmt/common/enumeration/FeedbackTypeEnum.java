package com.aoyukmt.common.enumeration;


import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public enum FeedbackTypeEnum {


    /**
     * 建议或意见
     */
    SUGGESTIONS("suggestions"),

    /**
     * bug
     */
    BUG("bug"),

    /**
     * 功能需求
     */
    FEATURE("feature"),

    /**
     * 其他
     */
    OTHER("other");

    FeedbackTypeEnum(String type) {
        this.type = type;
    };

    private final String type;

    // 使用懒加载模式确保线程安全
    private static class AllFeedbackTypesHolder {
        private static final Set<String> ALL_TYPES =
                Arrays.stream(FeedbackTypeEnum.values())
                        .map(FeedbackTypeEnum::getType)
                        .collect(Collectors.toUnmodifiableSet());
    }

    /**
     * 获取所有反馈类型的不可修改集合
     * @return 包含所有反馈类型的Set
     */
    public static Set<String> getAllFeedbackTypes() {
        return AllFeedbackTypesHolder.ALL_TYPES;
    }

    /**
     * 检查给定类型是否有效
     * @param type 要检查的类型
     * @return 如果类型有效返回true，否则返回false
     */
    public static boolean isValidType(String type) {
        return AllFeedbackTypesHolder.ALL_TYPES.contains(type);
    }

}

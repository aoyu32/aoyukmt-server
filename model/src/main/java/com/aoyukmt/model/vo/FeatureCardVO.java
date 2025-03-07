package com.aoyukmt.model.vo;

import lombok.Data;

/**
 * @ClassName：FeatureCardVO
 * @Author: aoyu
 * @Date: 2025-03-07 11:43
 * @Description: 主页功能特点展示卡片数据实体
 */

@Data
public class FeatureCardVO {
    /**
     * 功能唯一标识
     */
    private Integer id;

    /**
     * 表情字体图标
     */
    private String icon;

    /**
     * 功能特点名称
     */
    private String name;

    /**
     * 功能简短描述
     */
    private String description;
}

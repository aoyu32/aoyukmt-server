package com.aoyukmt.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：FeatureDetail
 * @Author: aoyu
 * @Date: 2025-03-07 11:36
 * @Description: 功能详情实体
 */

@Data
public class FeatureDetail {
    /**
     * 功能详情展示id
     */
    private Integer id;

    /**
     * 详情表情字体图标
     */
    private String icon;

    /**
     * 详情展示标题
     */
    private String title;

    /**
     * 详情展示内容
     */
    private String content;

    /**
     * 详情展示图片链接
     */
    private String imgUrl;

    /**
     * 图片替代文本
     */
    private String imgAlt;

    /**
     * 详情展示序号
     */
    private Integer sortOrder;

    /**
     * 是否展示，1展示，0不展示
     */
    private Boolean isActive;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
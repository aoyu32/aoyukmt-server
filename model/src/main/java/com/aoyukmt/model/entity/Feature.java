package com.aoyukmt.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：Feature
 * @Author: aoyu
 * @Date: 2025-03-06 17:02
 * @Description: 功能特点类
 */

@Data
public class Feature {
    /**
     * 唯一标识每个功能特点
     */
    private Integer id;

    /**
     * 表情字体图标
     */
    private String icon;

    /**
     * 功能特点名称，如"模块化设计"
     */
    private String name;

    /**
     * 功能特点详细描述
     */
    private String description;

    /**
     * 是否启用，true启用，false禁用
     */
    private Boolean isActive;

    /**
     * 排序优先级，值越小越靠前
     */
    private Integer sortOrder;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}

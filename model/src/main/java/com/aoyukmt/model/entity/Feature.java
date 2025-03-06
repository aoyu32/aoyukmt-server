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
    private int id;//id
    private String icon;//表情图标字体
    private String name;//功能特点名称
    private String description;//功能特点描述
    private boolean isActive;//是否使用
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}

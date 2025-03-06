package com.aoyukmt.model.vo;

import lombok.Data;

/**
 * @ClassName：FeatureVo
 * @Author: aoyu
 * @Date: 2025-03-06 17:19
 * @Description: 封装返回给前端的数据实体
 */
@Data
public class FeatureVo {
    private int id;//id
    private String icon;//表情图标字体
    private String name;//功能特点名称
    private String description;//功能特点描述
}

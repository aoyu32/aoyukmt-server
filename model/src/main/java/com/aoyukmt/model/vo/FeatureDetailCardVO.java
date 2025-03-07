package com.aoyukmt.model.vo;

import lombok.Data;

/**
 * @ClassName：FeatureDetailCardVO
 * @Author: aoyu
 * @Date: 2025-03-07 11:48
 * @Description: 主页功能详情展示数据实体
 */

@Data
public class FeatureDetailCardVO {

    /**
     * 详情唯一标识
     */
    private Integer id;

    /**
     * 表情字体图标
     */
    private String icon;

    /**
     * 详情标题
     */
    private String title;

    /**
     * 详情内容/说明文本
     */
    private String content;

    /**
     * 详情展示图片URL
     */
    private String imgUrl;


}

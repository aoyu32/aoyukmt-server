package com.aoyukmt.model.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName：Document
 * @Author: aoyu
 * @Date: 2025-03-08 16:24
 * @Description: 使用文档数据实体
 */

/**
 * 文档分类实体类，对应数据库中的 document_categories 表。
 * 该类用于存储文档的分类信息，每个分类下可以包含多个文档。
 */
@Data
public class DocumentCategory {

    /**
     * 分类 ID（主键，自增）。
     */
    private Integer id;

    /**
     * 分类名称，例如 "使用指南"、"常见问题"。
     */
    private String name;

    /**
     * 是否默认展开该分类下的子项：
     * - 1：展开
     * - 0：收起
     */
    private Integer isOpen;

    /**
     * 排序值，用于控制分类的显示顺序，数值越小，越靠前。
     */
    private Integer sortOrder;

    /**
     * 是否启用该分类：
     * - 1：启用
     * - 0：禁用
     */
    private Boolean isActive;

    /**
     * 该分类的创建时间，默认自动填充。
     */
    private LocalDateTime createTime;

    /**
     * 该分类的更新时间，在更新数据时自动修改。
     */
    private LocalDateTime updateTime;

    /**
     * 该分类下的所有文档，一对多关系。
     */
    private List<Document> documents;
}

package com.aoyukmt.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：Document
 * @Author: aoyu
 * @Date: 2025-03-08 16:29
 * @Description: 使用文档实体类
 */
/**
 * 文档实体类，对应数据库中的 documents 表。
 * 该类用于存储单个文档的基本信息和内容。
 */
@Data
public class Document {

    /**
     * 文档 ID（主键，自增）。
     */
    private Integer id;

    /**
     * 所属文档分类（外键）
     */
    private Integer categoryId;

    /**
     * 文档的标签，例如 "安装与启动"、"常见问题解答"。
     */
    private String label;

    /**
     * 文档内容的存储地址，通常是 Markdown 文件的 URL 或存储路径。
     */
    private String docsUrl;

    /**
     * 英文标签，用于支持多语言文档。
     */
    private String enLabel;

    /**
     * 文档的排序值，数值越小，显示越靠前。
     */
    private Integer sortOrder;

    /**
     * 是否启用该文档：
     * - true：启用
     * - false：禁用
     */
    private Boolean isActive;

    /**
     * 文档的创建时间，默认自动填充。
     */
    private LocalDateTime createTime;

    /**
     * 文档的更新时间，在更新数据时自动修改。
     */
    private LocalDateTime updateTime;
}

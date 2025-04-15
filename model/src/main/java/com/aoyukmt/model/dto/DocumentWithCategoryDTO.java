package com.aoyukmt.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName：DocumentDTO
 * @Author: aoyu
 * @Date: 2025-03-08 16:48
 * @Description: 所有分类下的所有文档实体
 */
@Data
public class DocumentWithCategoryDTO {
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
     * - 1:展开
     * - 0:收起
     */
    private Integer isOpen;

    /**
     * 该分类下的所有文档，一对多关系。
     */
    private List<DocumentDTO> documents;


}

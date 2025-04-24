package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：DocumentVO
 * @Author: aoyu
 * @Date: 2025-03-08 18:31
 * @Description: 使用文档信息数据实体类
 */

@Data
public class DocumentDTO {

    /**
     * 文档 ID（主键，自增）。
     */
    private Integer id;

    /**
     * 文档的标签，例如 "安装与启动"、"常见问题解答"。
     */
    private String label;

    /**
     * 文档内容的存储地址，通常是 Markdown 文件的 URL 或存储路径。
     */
    private String docsUrl;

    /**
     * 英文路由标签
     */
    private String enLabel;

}

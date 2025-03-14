package com.aoyukmt.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName：AppMetadata
 * @Author: aoyu
 * @Date: 2025-03-09 21:11
 * @Description: 应用元数据实体类
 */

/**
 * 应用元数据实体类，存储版本更新的额外信息，用于校验和更新机制。
 */
@Data
public class AppMetadata {
    /**
     * 应用元数据 ID
     */
    private Integer id;

    /**
     * 关联的版本日志 ID
     */
    private Integer versionId;

    /**
     * 关联的下载链接 ID
     */
    private Integer downloadId;

    /**
     * 应用签名
     */
    private String appSignature;

    /**
     * 是否强制更新: 1=是, 0=否
     */
    private Boolean forceUpdate;

    /**
     * 更新类型: incremental=增量更新, full=完整更新
     */
    private String updateType;

    /**
     * 发布人
     */
    private String releasedBy;

    /**
     * 兼容性信息
     */
    private String compatibility;

    /**
     * 版权信息
     */
    private String copyrightInfo;

    /**
     * 是否启用: 1=启用, 0=禁用
     */
    private Boolean isActive;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}

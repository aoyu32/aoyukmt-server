package com.aoyukmt.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：AppDownload
 * @Author: aoyu
 * @Date: 2025-03-09 21:05
 * @Description: 应用下载链接实体
 */

/**
 * 应用下载链接实体类，存储不同版本的下载地址。
 */
@Data
public class AppDownload {
    /**
     * 下载链接 ID
     */
    private Integer id;

    /**
     * 关联的版本日志 ID
     */
    private Integer versionId;

    /**
     * 安装程序 (EXE/DMG) 下载链接
     */
    private String installerUrl;

    /**
     * 完整安装包 (ZIP/TAR) 下载链接
     */
    private String zipPackageUrl;

    /**
     * 增量更新包下载链接
     */
    private String incrementalPackageUrl;

    /**
     * 安装包大小（MB）
     */
    private Float installerSize;

    /**
     * 完整压缩包大小（MB）
     */
    private Float zipPackageSize;

    /**
     * 增量更新包大小（MB）
     */
    private Float incrementalPackageSize;

    /**
     * 安装包 SHA-256 哈希值
     */
    private String installerHash;

    /**
     * 完整安装包 SHA-256 哈希值
     */
    private String zipPackageHash;

    /**
     * 增量更新包 SHA-256 哈希值
     */
    private String incrementalPackageHash;

    /**
     * 是否启用: 1=启用, 0=禁用
     */
    private Boolean isActive;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;
}

package com.aoyukmt.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：AppVersionLogWithDownloadDTO
 * @Author: aoyu
 * @Date: 2025-03-09 21:21
 * @Description: 应用版本日志和下载url实体
 */

@Data
public class AppVersionLogDTO {
    /**
     * 版本日志 ID
     */
    private Integer id;

    /**
     * 版本号
     */
    private String version;

    /**
     * 版本描述
     */
    private String description;

    /**
     * 发布日期
     */
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private LocalDateTime releaseDate;

    /**
     * 更新日志文档 URL
     */
    private String changelogUrl;


    /**
     * 安装包 SHA-256 哈希值
     */
    private String installerHash;

    /**
     * 完整安装包 SHA-256 哈希值
     */
    private String zipPackageHash;

}
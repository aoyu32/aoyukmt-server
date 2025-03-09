package com.aoyukmt.model.entity;

/**
 * @ClassName：AppVersionLog
 * @Author: aoyu
 * @Date: 2025-03-09 20:04
 * @Description: 应用版本日志实体
 */

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 应用版本日志实体类，记录应用的版本更新信息。
 */
@Data
public class AppVersionLog {
    /**
     * 版本日志 ID
     */
    private Integer id;

    /**
     * 版本号
     */
    private String version;

    /**
     * 版本类型: latest=最新版, history=历史版, beta=测试版
     */
    private String versionType;

    /**
     * 版本描述
     */
    private String description;

    /**
     * 发布日期
     */
    private LocalDateTime releaseDate;

    /**
     * 更新日志文档 URL
     */
    private String changelogUrl;

    /**
     * 是否激活: true=激活, false=不激活
     */
    private Boolean isActive;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime updatedTime;
}




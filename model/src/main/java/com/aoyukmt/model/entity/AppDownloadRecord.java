package com.aoyukmt.model.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppDownloadRecord {

    /**
     * 下载记录 ID
     */
    private Integer id;

    /**
     * 关联的版本日志 ID
     */
    private Integer versionId;

    /**
     * 唯一的下载用户标识
     */
    private String userId;

    /**
     * 用户 IP 地址
     */
    private String userIp;

    /**
     * 用户浏览器信息
     */
    private String userAgent;

    /**
     * 下载时间
     */
    private LocalDateTime downloadTime;

    /**
     * 下载的包类型（installer 或 zip）
     */
    private String packageType;

    /**
     * 是否成功返回安装包
     */
    private Boolean isSuccess;

}

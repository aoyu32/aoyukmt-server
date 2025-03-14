package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：AppDownloadRequestVO
 * @Author: aoyu
 * @Date: 2025-03-13 18:17
 * @Description: 请求下载参数实体
 */
@Data
public class AppDownloadLatestDTO {
    /**
     * 版本号
     */
    private String version;

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
     * 下载的包类型（installer 或 zip）
     */
    private String installerType;

}

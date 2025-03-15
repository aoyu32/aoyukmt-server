package com.aoyukmt.service.website.service;

import org.springframework.core.io.Resource;

/**
 * @InterfaceName：DownloadService
 * @Author: aoyu
 * @Date: 2025/3/13 上午10:21
 * @Description:
 */

public interface DownloadService {

    /**
     * 下载最新版本
     * @return 下载链接
     */
    String getLatestUrl(String downloadType);

    /**
     * 获取最新版本的版本号
     * @return 最新版本号
     */
    String getLatestVersionNumber();

    /**
     * 获取安装文件
     * @return 安装包文件
     */
    Resource getAppFile(String appFileName);

    /**
     *
     * @param version 版本号
     * @param packageType 安装包类型
     * @return 下载链接
     */
    String getHistoryUrl(String version,String packageType);


}

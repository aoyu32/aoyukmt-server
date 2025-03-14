package com.aoyukmt.service.website.service;

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
    String downloadLatest(String downloadType);

    /**
     * 获取最新版本的版本号
     * @return
     */
    String getLatestVersionNumber();

}

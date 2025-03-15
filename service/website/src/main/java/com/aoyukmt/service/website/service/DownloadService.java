package com.aoyukmt.service.website.service;

import com.aoyukmt.model.vo.HistoryAppVO;
import com.aoyukmt.model.vo.LatestAppVO;
import org.springframework.core.io.Resource;

/**
 * @InterfaceName：DownloadService
 * @Author: aoyu
 * @Date: 2025/3/13 上午10:21
 * @Description:
 */

public interface DownloadService {

    /**
     * 获取最新版本下载链接
     * @param latestAppVO 最新版本请求参数实体
     * @return 下载链接
     */
    String getLatestUrl(LatestAppVO latestAppVO);

    /**
     * 获取最新版本的版本号
     * @return 最新版本号
     */
    String getLatestVersionNumber();

    /**
     * 获取安装文件
     * @return 安装包文件
     */
    Resource getAppFile(String versionType,String appFileName);

    /**
     *获取历史版本下载链接
     * @param historyAppVO 历史版本请求参数实体
     * @return 下载链接
     */
    String getHistoryUrl(HistoryAppVO historyAppVO);


}

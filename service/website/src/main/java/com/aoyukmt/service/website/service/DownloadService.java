package com.aoyukmt.service.website.service;

import com.aoyukmt.model.entity.AppDownloadRecord;
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
     * 获取最新版本id
     * @return 最新版本id
     */
    Integer getLatestVersionId();

    /**
     * 更加版本号获取id
     * @param versionNumber 版本号
     * @return 该版本的id
     */
    Integer getVersionId(String versionNumber);


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

    /**
     * 插入一条用户下载记录
     * @param appDownloadRecord 用户下载记录实体
     */
    void addDownloadRecord(AppDownloadRecord appDownloadRecord);



}

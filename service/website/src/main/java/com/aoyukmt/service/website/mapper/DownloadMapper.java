package com.aoyukmt.service.website.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @InterfaceName：DownloadMapper
 * @Author: aoyu
 * @Date: 2025/3/13 上午10:23
 * @Description:
 */
@Mapper
public interface DownloadMapper {

    /**
     * 根据下载的安装包类型查询最新版的下载链接
     * @return
     */
    String selectLatestDownloadUrl(String downloadType);

    /**
     * 获取最新版本的版本号
     * @return
     */
    @Select("select version from app_version_log where version_type = 'latest' and is_active = 1")
    String selectLatestVersionNumber();

    /**
     * 根据版本号和安装包类型查询历史版本的下载链接
     * @param version 版本号
     * @param packageType 安装包类型
     * @return 该历史版本的下载链接
     */
    String selectHistoryDownloadUrl(String version,String packageType);
}

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
}

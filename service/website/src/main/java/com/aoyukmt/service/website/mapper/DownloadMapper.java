package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.entity.AppDownloadRecord;
import org.apache.ibatis.annotations.Insert;
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
     *
     * @return
     */
    String selectLatestDownloadUrl(String downloadType);

    /**
     * 获取最新版本的版本号
     *
     * @return
     */
    @Select("select version from app_version_log where version_type = 'latest' and is_active = 1")
    String selectLatestVersionNumber();

    /**
     * 根据版本号和安装包类型查询历史版本的下载链接
     *
     * @param version     版本号
     * @param packageType 安装包类型
     * @return 该历史版本的下载链接
     */
    String selectHistoryDownloadUrl(String version, String packageType);

    /**
     * 查询最新版本id
     *
     * @return 最新版本id
     */
    @Select("select id from app_version_log where version_type='latest' and is_active=1")
    Integer selectLatestVersionId();

    /**
     * 根据版本号查询id
     *
     * @return 该版本id
     */
    @Select("select id from app_version_log where version=#{version} and is_active = 1")
    Integer selectVersionId(String version);

    /**
     * 插入一条用户下载记录
     *
     * @param appDownloadRecord 用户下载记录数据
     */
    @Insert("INSERT INTO app_download_record (version_id, user_id, user_ip, user_agent, download_time, package_type, is_success) " +
            "VALUES (#{versionId}, #{userId}, #{userIp}, #{userAgent}, #{downloadTime}, #{packageType}, #{isSuccess})")
    void insertDownloadRecord(AppDownloadRecord appDownloadRecord);

}

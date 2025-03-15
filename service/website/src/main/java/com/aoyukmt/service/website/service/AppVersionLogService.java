package com.aoyukmt.service.website.service;

import com.aoyukmt.model.dto.AppVersionLogDTO;

import java.util.List;

/**
 * @InterfaceName：VersionLogService
 * @Author: aoyu
 * @Date: 2025/3/9 下午9:45
 * @Description:
 */

public interface AppVersionLogService {

    /**
     * 查询最新版本日志和下载链接和文件哈希
     */
    AppVersionLogDTO getLatestVersionLog();
    /*
     *根据版本类型查询版本日志和下载链接和文件哈希
     */
    List<AppVersionLogDTO> getLatestVersionLog(String versionType);

}

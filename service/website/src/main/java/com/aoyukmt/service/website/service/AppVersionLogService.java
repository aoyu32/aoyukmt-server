package com.aoyukmt.service.website.service;

import com.aoyukmt.model.dto.AppVersionLogWithDownloadDTO;
import com.aoyukmt.model.entity.AppVersionLog;

import java.util.List;

/**
 * @InterfaceName：VersionLogService
 * @Author: aoyu
 * @Date: 2025/3/9 下午9:45
 * @Description:
 */

public interface AppVersionLogService {

    /*
     *查询最新版本日志和下载链接和文件哈希
     */
    List<AppVersionLogWithDownloadDTO> getLatestVersionLog(String versionType);

}

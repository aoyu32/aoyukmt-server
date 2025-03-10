package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.AppVersionLogWithDownloadDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName：VersionLogController
 * @Author: aoyu
 * @Date: 2025/3/9 下午8:03
 * @Description:
 */

@Mapper
public interface AppVersionLogMapper {

    /**
     * 获取最新版本日志
     * @return
     */
    AppVersionLogWithDownloadDTO getLatestVersionLog();

    /*
     *根据类型查询版本日志和下载链接和文件哈希
     * 参数为"history","beta"
     * @return
     */
    List<AppVersionLogWithDownloadDTO> selectVersionLogByType(@Param("versionType") String versionType);



}

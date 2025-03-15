package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.model.dto.AppVersionLogDTO;
import com.aoyukmt.service.website.mapper.AppVersionLogMapper;
import com.aoyukmt.service.website.service.AppVersionLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName：AppVersionLogServiceImpl
 * @Author: aoyu
 * @Date: 2025-03-09 21:47
 * @Description: 应用更新日志接口实现类
 */
@Service
public class AppVersionLogServiceImpl implements AppVersionLogService {

    private static final Logger log = LoggerFactory.getLogger(AppVersionLogServiceImpl.class);
    @Autowired
    private AppVersionLogMapper appVersionLogMapper;

    /**
     *查询最新版本日志和下载链接和文件哈希
     * @return
     */
    @Override
    public AppVersionLogDTO getLatestVersionLog() {
        log.info("获取最新版本日志信息...");
//        throw new BusinessException(ResultCode.SERVICE_UNAVAILABLE);
        return appVersionLogMapper.getLatestVersionLog();
    }

    /*
     *根据版本类型查询版本日志和下载链接和文件哈希
     *参数为："history","beta"
     */
    @Override
    public List<AppVersionLogDTO> getLatestVersionLog(String versionType) {
        log.info("获取 {} 版本日志信息...", versionType);
//        throw new BusinessException(ResultCode.SYSTEM_ERROR);
        return appVersionLogMapper.selectVersionLogByType(versionType);
    }
}

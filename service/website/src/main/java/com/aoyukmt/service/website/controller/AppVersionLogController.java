package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.constant.VersionTypeConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.dto.AppVersionLogDTO;
import com.aoyukmt.service.website.service.AppVersionLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * @ClassName：AppVersionLogController
 * @Author: aoyu
 * @Date: 2025-03-09 21:54
 * @Description: 应用版本日志控制类
 */
@Tag(name = "应用版本日志", description = "应用版本日志相关接口")
@RestController
@RequestMapping("/web/changelog")
public class AppVersionLogController {

    private static final Logger log = LoggerFactory.getLogger(AppVersionLogController.class);
    @Autowired
    private AppVersionLogService appVersionLogService;

    @Operation(summary = "获取最新版本日志",description = "获取最新版本的版本日志信息")
    @GetMapping("/latest")
    public Result<AppVersionLogDTO> getLatestAppVersionLog() {
        log.info("请求获取最新应用版本日志信息...");
        AppVersionLogDTO latestVersionLog = appVersionLogService.getLatestVersionLog();
        log.info("最新版本日志信息数据：{}" , latestVersionLog);
        return Result.success(latestVersionLog);
    }


    @Operation(summary = "根据版本类型获取版本日志", description = "根据版本类型获取应用的版本日志信息")
    @GetMapping("/{versionType}")
    public Result<List<AppVersionLogDTO>> getVersionLogByType(@PathVariable String versionType) {
        String historyVersion = VersionTypeConstant.HISTORY_VERSION;
        String betaVersion = VersionTypeConstant.BETA_VERSION;
        if(!Set.of(historyVersion,betaVersion).contains(versionType)){
            throw new BusinessException(ResultCode.PARAM_ERROR);
        }
        log.info("请求获取{}版本类型的应用版本日志信息",versionType);
        List<AppVersionLogDTO> versionLogs = appVersionLogService.getLatestVersionLog(versionType);
        log.info("版本类型为：{} 版本日志信息数据：{}", versionType, versionLogs);
        return Result.success(versionLogs);
    }

}

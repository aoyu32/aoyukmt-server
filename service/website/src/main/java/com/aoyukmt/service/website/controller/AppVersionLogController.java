package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.constant.VersionTypeConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.dto.AppVersionLogWithDownloadDTO;
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
@RequestMapping("/web/api")
public class AppVersionLogController {

    private static final Logger log = LoggerFactory.getLogger(AppVersionLogController.class);
    @Autowired
    private AppVersionLogService appVersionLogService;

    @Operation(summary = "根据版本类型获取版本日志", description = "根据版本类型获取应用的版本日志信息")
    @GetMapping("/changelog/{versionType}")
    public Result<?> getLatestAppVersionLog(@PathVariable String versionType) {
        if(!Set.of("latest", "history", "beta").contains(versionType)){
            throw new BusinessException(ResultCode.PARAM_ERROR);
        }
        log.info("请求获取最新应用版本日志信息...");
        List<AppVersionLogWithDownloadDTO> latestVersionLog = appVersionLogService.getLatestVersionLog(versionType);
        log.info("{} 版本日志信息数据：{}", versionType, latestVersionLog);
        if (versionType.equals(VersionTypeConstant.LATEST_VERSION)) {
            return Result.success(latestVersionLog.get(0));
        }
        return Result.success(latestVersionLog);
    }

}

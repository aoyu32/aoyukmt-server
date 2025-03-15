package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.service.website.service.DownloadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName：DownloadController
 * @Author: aoyu
 * @Date: 2025-03-13 10:17
 * @Description: 应用下载接口
 */
@Tag(name = "应用下载", description = "官网请求下载安装包")
@RestController
@RequestMapping("/web/download")
public class DownloadController {

    private static final Logger log = LoggerFactory.getLogger(DownloadController.class);

    @Autowired
    private DownloadService downloadService;


    /**
     * @description: 最新版本下载链接接口
     * @author: aoyu
     * @date: 2025/3/15 下午1:14
     * @param: 安装包类型,下载用户id
     * @return: 最新版本下载链接
     */
    @Operation(summary = "获取最新版的下载链接", description = "根据下载的安装包类型获取最新版本的下载链接")
    @GetMapping("/latest/{packageType}/{uid}")
    public Result<String> latestDownloadUrl(@PathVariable String packageType, @PathVariable String uid) {
        log.info("{}请求获取最新版本的 {} 下载链接...",uid,packageType);
        String latestUrl = downloadService.getLatestUrl(packageType);
        log.info("最新版本的下载链接：{}",latestUrl);
        return Result.success(latestUrl);
    }

    /**
     * @description: 安装包文件下载接口
     * @author: aoyu
     * @date: 2025/3/15 下午1:15
     * @param: 应用全名
     * @return: 安装包文件
     */
    @Operation(summary = "下载某个版本的安装包",description = "根据请求下载的应用全名下载对应的安装包")
    @GetMapping("/latest/{appFileName}")
    public ResponseEntity<Resource> downloadLatest(@PathVariable String appFileName) throws IOException {
        log.info("请求下载最新版本 {} 安装包：", appFileName);
        Resource appFile = downloadService.getAppFile(appFileName);
        System.out.println(appFile.contentLength());
        return ResponseEntity.ok()
                .contentLength(appFile.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + appFile.getFilename() + "\"")
                .body(appFile);
    }


    /**
     * @description: 历史版本下载链接接口
     * @author: aoyu
     * @date: 2025/3/15 下午7:55
     * @param: 版本号，安装包类型，下载用户id
     * @return: 该历史版本的下载链接
     */
    @Operation(summary = "获取某个历史版本的下载链接",description = "根据版本号和安装包类型获取对应的历史版本的安装包的下载链接")
    @GetMapping("/history/{version}/{packageType}/{uid}")
    public Result<String> historyDownloadUrl(@PathVariable String version, @PathVariable String packageType,@PathVariable String uid) {
       log.info("{} 请求下载 版本为 {} 安装方式为 {} 的应用包：", uid,version, packageType);
        String historyUrl = downloadService.getHistoryUrl(version, packageType);
        log.info("历史版本：{} 的 {} 安装包下载链接 {}",version,packageType,historyUrl);
        return Result.success(historyUrl);
    }

}

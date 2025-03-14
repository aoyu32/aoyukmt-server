package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.constant.DownloadConstants;
import com.aoyukmt.common.constant.VersionTypeConstant;
import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.dto.AppDownloadLatestDTO;
import com.aoyukmt.service.website.service.DownloadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;

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

    @Value("${file.app-resources-path}")
    private String appResourcesPath;

    @Value("${file.app_name}")
    private String appName;

    @Operation(summary = "获取最新版下载链接",description = "根据下载的安装包类型获取最新版本的下载链接")
    @GetMapping("/latest/{downloadType}")
    public Result<String> downloadLatest(@PathVariable String downloadType) {
        log.info("请求获取最新版本的下载链接...");
        String latestUrl = downloadService.downloadLatest(downloadType);
        return Result.success(latestUrl);
    }

//    @Operation(summary = "下载最新版本", description = "根据下载的安装包类型下载最新版本的应用文件")
//    @PostMapping("/latest")
//    public ResponseEntity<InputStreamResource> downloadLatest(@RequestBody AppDownloadLatestDTO downloadParam) throws Exception {
//        //安装包类型
//        String installerType = downloadParam.getInstallerType();
//        log.info("请求下载最新版：安装包类型：{}", downloadParam.getInstallerType());
//        //获取最新版本号
//        String latestVersionNumber = downloadService.getLatestVersionNumber();
//        String fileName = appName + "-" + latestVersionNumber;
//        if (installerType.equals(DownloadConstants.INSTALLER)) {
//            fileName = fileName + DownloadConstants.EXE_FILE;
//        } else {
//            fileName = fileName + DownloadConstants.ZIP_FILE;
//        }
//        StringBuilder stringBuilder = new StringBuilder(appResourcesPath);
//
//        String filePath = stringBuilder.append("\\").append(installerType).append("\\").append(VersionTypeConstant.LATEST_VERSION)
//                .append("\\").append(fileName).toString();
//
//        log.info("最新版本安装包文件路径：{}", filePath);
//
//        //创建输入流
//        File file = new File(filePath);
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        //设置响应头
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
//        headers.add("Access-Control-Expose-Headers", "Content-Disposition");
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//        //返回数据流
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(file.length())
//                .body(new InputStreamResource(fileInputStream));
//
//    }
}

package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.common.constant.DownloadConstants;
import com.aoyukmt.common.constant.VersionTypeConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.service.website.mapper.DownloadMapper;
import com.aoyukmt.service.website.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @ClassName：DownloadServiceImpl
 * @Author: aoyu
 * @Date: 2025-03-13 10:22
 * @Description: 下载链接接口实现类
 */
@Service
public class DownloadServiceImpl implements DownloadService {

    private static final Logger log = LoggerFactory.getLogger(DownloadServiceImpl.class);
    @Autowired
    private DownloadMapper downloadMapper;

    //存放安装包资源的路径
    @Value("${file.app-resources-path}")
    private String appResourcesPath;


    /**
     * 获取最新版本下载链接
     * @param packageType 安装包类型
     * @return 最新版本的下载链接
     */
    @Override
    public String getLatestUrl(String packageType) {
        log.info("获取最新版本下载链接......");
        String latestUrl = downloadMapper.selectLatestDownloadUrl(packageType);
        if(latestUrl == null){
            throw new BusinessException(ResultCode.RESOURCES_NOT_EXITS);
        }
        return latestUrl;
    }

    /**
     * 获取最新版本的版本号
     * @return 版本号
     */
    @Override
    public String getLatestVersionNumber() {
        return downloadMapper.selectLatestVersionNumber();
    }

    /**
     * 根据文件名获取安装文件
     *
     * @param appFileName 文件名
     * @return 安装包文件
     */
    @Override
    public Resource getAppFile(String appFileName) {
        // 验证文件名格式
        if (appFileName == null || appFileName.isEmpty() || appFileName.contains("..") ||
                appFileName.contains("/") || appFileName.contains("\\")) {
            log.warn("非法文件名请求: {}", appFileName);
            throw new BusinessException(ResultCode.INVALID_FILENAME);
        }

        //  获取文件扩展名
        String extension = "";
        int lastDotIndex = appFileName.lastIndexOf(".");
        if (lastDotIndex > 0) {
            extension = appFileName.substring(lastDotIndex).toLowerCase();
        }

        //  构建本地文件路径
        String filePath = appResourcesPath + File.separator;
        if (extension.equals(DownloadConstants.EXE_FILE)) {
            filePath = filePath + DownloadConstants.INSTALLER + File.separator + VersionTypeConstant.LATEST_VERSION + File.separator + appFileName;
            log.info("构建文件本地路径: {}", filePath);
        }
        if (extension.equals(DownloadConstants.ZIP_FILE)) {
            filePath = filePath + DownloadConstants.ZIP + File.separator + VersionTypeConstant.LATEST_VERSION + File.separator + appFileName;
            log.info("构建文件本地路径: {}", filePath);
        }

        // 检查文件是否存在
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            log.error("请求的文件不存在: {}", filePath);
            throw new BusinessException(ResultCode.RESOURCES_NOT_EXITS);
        }

        try {
            return new FileSystemResource(file);
        } catch (Exception e) {
            log.error("获取文件发生错误", e);
            throw new BusinessException(ResultCode.DOWNLOAD_FAILED);
        }
    }

    /**
     * 获取历史版本下载链接
     * @param version 历史版本号
     * @param packageType 安装包类型
     * @return 下载链接
     */
    @Override
    public String getHistoryUrl(String version, String packageType) {
        log.info("获取历史版本号为 {} 安装包类型为 {} 的下载链接：",version,packageType);
        String historyUrl = downloadMapper.selectHistoryDownloadUrl(version,packageType);
        if(historyUrl==null){
            throw new BusinessException(ResultCode.RESOURCES_NOT_EXITS);
        }
        return historyUrl;
    }
}

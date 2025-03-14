package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.service.website.mapper.DownloadMapper;
import com.aoyukmt.service.website.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName：DownloadServiceImpl
 * @Author: aoyu
 * @Date: 2025-03-13 10:22
 * @Description: 下载链接接口实现类
 */
@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private DownloadMapper downloadMapper;

    /**
     * 获取最新版本下载链接
     * @return
     */
    @Override
    public String downloadLatest(String downloadType) {
        return downloadMapper.selectLatestDownloadUrl(downloadType);
    }

    /**
     * 获取最新版本的版本号
     * @return
     */
    @Override
    public String getLatestVersionNumber() {
        return downloadMapper.selectLatestVersionNumber();
    }
}

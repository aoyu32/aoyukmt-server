package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.common.utils.AliYunOSSUtils;
import com.aoyukmt.service.website.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName：OssServiceImpl
 * @Author: aoyu
 * @Date: 2025-04-20 15:33
 * @Description: oss服务实现类
 */

@Service
public class OssServiceImpl implements OssService {

    @Autowired
    private AliYunOSSUtils aliyunOSSUtils;


    @Override
    public String upload(MultipartFile file,String ossDir) throws IOException {
        return aliyunOSSUtils.uploadFile(file.getBytes(), file.getOriginalFilename(),ossDir);
    }


    @Override
    public List<String> uploadFileList(List<MultipartFile> fileList,String ossDir) throws IOException {
        // 使用 List<Object[]> 来存储文件名和字节数组
        List<Object[]> fileInfoList = fileList.stream()
                .map(file -> {
                    try {
                        // 返回一个包含文件名和文件字节数组的 Object 数组
                        return new Object[]{file.getOriginalFilename(), file.getBytes()};
                    } catch (IOException e) {
                        throw new RuntimeException("Error reading file: " + file.getOriginalFilename(), e);
                    }
                })
                .toList();

        // 上传文件并返回文件的 URL 列表
        return fileInfoList.stream()
                .map(fileInfo -> {
                    String fileName = (String) fileInfo[0];
                    byte[] fileData = (byte[]) fileInfo[1];
                    return aliyunOSSUtils.uploadFile(fileData, fileName,ossDir);
                })
                .collect(Collectors.toList());
    }

}

package com.aoyukmt.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.ByteArrayInputStream;
import java.util.UUID;

/**
 * @ClassName：AliyunOSSUtils
 * @Author: aoyu
 * @Date: 2025-03-07 13:07
 * @Description: 阿里云oss工具类
 */

@Data
@AllArgsConstructor
public class AliYunOSSUtils {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;


    //生成文件唯一文件名
    public String generateFileName(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + extension;
    }

    /**
     * 文件上传
     *
     * @param file
     * @param fileName
     * @return
     */
    public String uploadFile(byte[] file, String fileName) throws RuntimeException {

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String objectName = generateFileName(fileName);
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(file));
        return "https://" + bucketName + "." + endpoint + "/" + objectName;
    }
}

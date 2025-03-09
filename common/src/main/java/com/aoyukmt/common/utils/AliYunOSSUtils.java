package com.aoyukmt.common.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(AliYunOSSUtils.class);
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    /**
     * 生成文件唯一文件名
     * @param fileName
     * @return
     */
    public String generateFileName(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID() + extension;
    }

    /**
     * 文件上传
     *
     * @param file
     * @param fileName
     * @return
     */
    public String uploadFile(byte[] file, String fileName){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String objectName = generateFileName(fileName);
        try {
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(file));
        }catch (OSSException oe) {
//            log.error("OSS异常，准备抛出BusinessException");
//           throw new BusinessException(ResultCode.OSS_EXCEPTION);
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        }catch (ClientException ce){
//            log.error("捕获到业务异常: class={}, message={}",
//                    e.getClass().getName(), e.getMessage());
//            throw new BusinessException(ResultCode.OSS_EXCEPTION);
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        }finally {
            if (ossClient!=null){
                ossClient.shutdown();
            }
        }
        return "https://" + bucketName + "." + endpoint + "/" + objectName;
    }
}

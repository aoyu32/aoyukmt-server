package com.aoyukmt.common.config;

import com.aoyukmt.common.utils.AliYunOSSUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName：AliOSSConfig
 * @Author: aoyu
 * @Date: 2025-03-07 20:58
 * @Description: 阿里云oss配置类
 */

@Configuration
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class AliOSSConfiguration {

    private  String endpoint;
    private  String accessKeyId;
    private  String accessKeySecret;
    private  String bucketName;

    @Bean
    public AliYunOSSUtils getAliOSSUtils() {
        return new AliYunOSSUtils(endpoint, accessKeyId, accessKeySecret, bucketName);
    }

}

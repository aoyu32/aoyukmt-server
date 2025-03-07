package com.aoyukmt.service.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName：AoyukmtServiceWebsiteApplication
 * @Author: aoyu
 * @Date: 2025-03-06 14:33
 * @Description: aoyukmt网站服务启动类
 */

@SpringBootApplication(scanBasePackages = {"com.aoyukmt.common", "com.aoyukmt.service.website"})
@MapperScan(basePackages = "com.aoyukmt.service.website.mapper")
public class AoyukmtServiceWebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(AoyukmtServiceWebsiteApplication.class,args);
    }
}

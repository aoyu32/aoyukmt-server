package com.aoyukmt.service.website.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName：Knife4jConfig
 * @Author: aoyu
 * @Date: 2025-03-06 15:11
 * @Description: knife4j接口文档配置类
 */

@Configuration
public class Knife4jConfig{

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                .title("AOYUKMT官方网站接口文档")
                .version("1.0")
                .description("aoyukmt的官方网站接口文档")
        );
    }


}

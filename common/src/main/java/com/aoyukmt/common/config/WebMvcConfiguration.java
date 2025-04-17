package com.aoyukmt.common.config;

import com.aoyukmt.common.interceptor.DownloadInterceptor;
import com.aoyukmt.common.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName：WebMvcConfiguration
 * @Author: aoyu
 * @Date: 2025-03-08 21:13
 * @Description: mvc配置类
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private DownloadInterceptor downloadInterceptor;

    @Autowired
    private JwtInterceptor jwtInterceptor;

    //前后端跨域处理
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .exposedHeaders("Content-Disposition");;

    }

    //注册下载请求拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(downloadInterceptor)
                .addPathPatterns("/web/download/**");

        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/web/user/**")
                .addPathPatterns("/web/auth/**")
                .excludePathPatterns("/web/auth/login","/web/auth/register");

    }
}

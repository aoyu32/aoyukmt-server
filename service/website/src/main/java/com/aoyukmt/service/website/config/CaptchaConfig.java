package com.aoyukmt.service.website.config;

import com.anji.captcha.properties.AjCaptchaProperties;
import com.anji.captcha.service.CaptchaCacheService;
import com.anji.captcha.service.impl.CaptchaServiceFactory;
import com.aoyukmt.service.website.service.impl.CaptchaCacheServiceRedisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName：CaptchaConfig
 * @Author: aoyu
 * @Date: 2025-04-04 21:46
 * @Description: 验证码配置类
 */

@Configuration
public class CaptchaConfig {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean(name = "CaptchaCacheService")
    @Primary
    public CaptchaCacheService captchaCacheService() {
        CaptchaCacheServiceRedisImpl redisCacheService = new CaptchaCacheServiceRedisImpl();
        redisCacheService.setStringRedisTemplate(redisTemplate);
        return redisCacheService;
    }

    @Bean
    @ConditionalOnMissingBean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/messages", "captcha/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
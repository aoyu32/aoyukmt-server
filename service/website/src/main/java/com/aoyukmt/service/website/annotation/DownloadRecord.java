package com.aoyukmt.service.website.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 记录下载用户信息注解
 * @author: aoyu
 * @date: 2025/3/16 下午1:55
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DownloadRecord {
}

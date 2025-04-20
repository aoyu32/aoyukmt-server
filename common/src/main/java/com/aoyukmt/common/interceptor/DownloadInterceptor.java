package com.aoyukmt.common.interceptor;

import com.aoyukmt.common.constant.DownloadConstant;
import com.aoyukmt.common.constant.RedisKeyPrefixConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName：DownloadInterceptor
 * @Author: aoyu
 * @Date: 2025-03-12 22:06
 * @Description: 下载请求拦截器
 */

@Component
@Slf4j
public class DownloadInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求者ip地址
        String ip = request.getRemoteAddr();
        //键
        String key = RedisKeyPrefixConstant.RATE_LIMIT + ip;
        //向redis中记录请求ip的数据,并让值加一后返回
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        //如果值为1，说明为第一次请求，设置键值过期时间
        if (increment == 1) {
            redisTemplate.expire(key, DownloadConstant.TIME_WINDOW, TimeUnit.SECONDS);
        }
        //判断是否超过限制
        if(increment > DownloadConstant.MAX_REQUESTS){
            throw new BusinessException(ResultCode.TOO_MANY_REQUESTS);
        }
        log.info("请求下载的IP : {},当前次数：{}", ip,increment);
        return true;
    }
}

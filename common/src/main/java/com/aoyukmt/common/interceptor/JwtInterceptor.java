package com.aoyukmt.common.interceptor;

import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.utils.JwtUtils;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @ClassName：RequestInterceptor
 * @Author: aoyu
 * @Date: 2025-04-08 10:17
 * @Description: 请求拦截器
 */

@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {

        //获取请求头中的token
        String token = request.getHeader("authorization");

        log.info("获取请求头中的token:{}", token);
        //如果获取不到token信息
        if (token == null) {
            throw new BusinessException(ResultCode.UN_LOGIN);
        }

        //取出token部分
        String tokenRaw = token.substring(7);


        //校验token是否有效
        log.info("token是否过期：{}",jwtUtils.isTokenExpired(tokenRaw));
        if (jwtUtils.isTokenExpired(tokenRaw)) {
            throw  new BusinessException(ResultCode.TOKEN_EXPIRED);
        }

        //判断token是否有效
        log.info("token是否有效：{}",jwtUtils.validateToken(tokenRaw));
        if(!jwtUtils.validateToken(tokenRaw)){
            throw new BusinessException(ResultCode.TOKEN_VALIDATE_FAIL);
        }

        //从token中获取uid
        String uid = jwtUtils.getSubjectFromToken(tokenRaw);
        log.info("token有效，获取请求的uid{}",uid);
        ThreadLocalUtils.set("uid",uid);

        return true;
    }

}

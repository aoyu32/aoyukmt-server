package com.aoyukmt.service.website.aop;

import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.interfaces.CaptchaVerifiable;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName：UserAuthAspect
 * @Author: aoyu
 * @Date: 2025-04-09 17:00
 * @Description: 用户认证切面类，用于执行接口方法前进行滑块验证码的二次校验，和执行完成后记录用户登录信息
 */

@Component
@Aspect
@Slf4j
public class UserAuthAspect {

    @Autowired
    private CaptchaService captchaService ;

    @Pointcut("@annotation(com.aoyukmt.service.website.annotation.UserAuth)")
    public void userAuthPoint() {
    }


    @Around("userAuthPoint()")
    public Object userAuth(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("<<<<<<<<<<<<<<<<<开始进行验证码的二次校验>>>>>>>>>>>>>>>>>>>>");

        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法名
        String methodName = signature.getName();
        // 获取参数数组
        Object[] args = joinPoint.getArgs();

        log.info("请求方法：{}", methodName);
        log.info("请求参数：{}", args);
        CaptchaVerifiable captchaCode = (CaptchaVerifiable) args[0];
        log.info("二次验证码：{}", captchaCode.getCaptchaCode());

        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaVerification(captchaCode.getCaptchaCode());
        ResponseModel verification = captchaService.verification(captchaVO);
        log.info("二次验证结果：{}",verification);
        if(!verification.getRepCode().equals("0000")){
            throw new BusinessException(ResultCode.VERIFY_CODE_ERROR);
        }

        // 执行目标方法获取返回值
        Object result = joinPoint.proceed();
        log.info("<<<<<<<<<<<<<<<<<结束验证码的二次校验>>>>>>>>>>>>>>>>>>>>");
        return result;
    }


}

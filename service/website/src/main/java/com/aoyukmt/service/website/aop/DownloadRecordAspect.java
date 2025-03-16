package com.aoyukmt.service.website.aop;

import com.aoyukmt.common.constant.DownloadConstants;
import com.aoyukmt.common.constant.RedisKeyPrefixConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.entity.AppDownloadRecord;
import com.aoyukmt.model.vo.HistoryAppVO;
import com.aoyukmt.model.vo.LatestAppVO;
import com.aoyukmt.service.website.service.DownloadService;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName：DownloadRecordAspect
 * @Author: aoyu
 * @Date: 2025-03-16 13:44
 * @Description: 记录下载接口的下载用户信息的切面类
 */

@Component
@Aspect
public class DownloadRecordAspect {

    private static final Logger log = LoggerFactory.getLogger(DownloadRecordAspect.class);

    @Autowired
    private DownloadService downloadService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 匹配带有DownloadRecord注解的方法
    @Pointcut("@annotation(com.aoyukmt.service.website.annotation.DownloadRecord)")
    public void downloadRecordPointcut() {
    }

    // 返回后通知
    @Around("downloadRecordPointcut()")
    public Object downloadFileRecord(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("开始记录下载用户信息......");

        // 获取当前请求信息
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        if (servletRequestAttributes == null) {
            log.warn("请求属性为空，无法获取请求信息");
            return null;
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();

        log.info("请求：{}", request);

        // 获取请求客户端IP
        String userIP = request.getRemoteAddr();
        log.info("用户IP：{}", userIP);
        // 获取请求客户端user-agent
        String userAgent = request.getHeader("User-Agent");
        log.info("用户user-agent：{}", userAgent);

        // 创建下载记录对象
        AppDownloadRecord appDownloadRecord = new AppDownloadRecord();

        // 获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法名
        String methodName = signature.getName();
        // 获取参数数组
        Object[] args = joinPoint.getArgs();

        log.info("请求方法：{}", methodName);
        log.info("请求参数：{}", args);

        // 判断是否是下载链接请求还是下载应用请求
        if (Set.of("latestDownloadUrl", "historyDownloadUrl").contains(methodName)) {
            log.info("处理下载链接请求");

            // 如果是请求最新版本下载链接
            if (args[0] instanceof LatestAppVO) {
                Integer latestVersionId = downloadService.getLatestVersionId();
                String uid = ((LatestAppVO) args[0]).getUid();
                String packageType = ((LatestAppVO) args[0]).getPackageType();
                appDownloadRecord.setUserId(uid);
                appDownloadRecord.setUserIp(userIP);
                appDownloadRecord.setUserAgent(userAgent);
                appDownloadRecord.setVersionId(latestVersionId);
                appDownloadRecord.setPackageType(packageType);
                appDownloadRecord.setIsSuccess(false);
                log.info("记录下载链接请求 - 最新版：userId={}, versionId={}, packageType={}", uid, latestVersionId, packageType);
            }

            // 如果是请求历史版本下载链接
            if (args[0] instanceof HistoryAppVO) {
                String version = ((HistoryAppVO) args[0]).getVersion();
                Integer versionId = downloadService.getVersionId(version);
                String uid = ((HistoryAppVO) args[0]).getUid();
                String packageType = ((HistoryAppVO) args[0]).getPackageType();
                appDownloadRecord.setUserId(uid);
                appDownloadRecord.setUserIp(userIP);
                appDownloadRecord.setUserAgent(userAgent);
                appDownloadRecord.setVersionId(versionId);
                appDownloadRecord.setPackageType(packageType);
                appDownloadRecord.setIsSuccess(false);
                log.info("记录下载链接请求 - 历史版：userId={}, versionId={}, packageType={}", uid, versionId, packageType);
            }

            // 生成下载id作为key存入redis中
            String downloadId = UUID.randomUUID().toString();
            redisTemplate.opsForValue().set(RedisKeyPrefixConstant.DOWNLOAD_ID + downloadId, appDownloadRecord, DownloadConstants.DOWNLOAD_ID_TIMEOUT, TimeUnit.SECONDS);
            log.info("下载ID已存入Redis: {}", downloadId);

            // 执行目标方法获取返回值
            Object result = joinPoint.proceed();
            log.info("返回结果：{}", result);

            // 修改返回结果，添加下载唯一标识
            if (result instanceof Result<?> res) {
                if (res.getData() instanceof String url) {
                    // 添加downloadId作为查询参数
                    url = url + "/" + downloadId;
                    log.info("修改URL，添加下载ID: {}", url);
                    return Result.success(url);
                }
            }

        } else if ("downloadApplication".equals(methodName)) {
            String downloadId = args[2].toString();
            log.info("处理下载应用请求，下载ID: {}", downloadId);

            AppDownloadRecord downloadRecord = null;
            if (downloadId != null) {
                downloadRecord = (AppDownloadRecord) redisTemplate.opsForValue().get(RedisKeyPrefixConstant.DOWNLOAD_ID + downloadId);
                if (downloadRecord == null) {
                    log.error("下载记录不存在，可能是非法请求");
                    throw new BusinessException(ResultCode.NOT_OFFICIAL_DOWNLOAD);
                } else {
                    redisTemplate.delete(RedisKeyPrefixConstant.DOWNLOAD_ID + downloadId);
                    log.info("下载记录已删除，下载ID: {}", downloadId);
                }
            }

            // 执行原方法
            Object result = joinPoint.proceed();

            // 判断是否成功返回安装包
            if (result instanceof ResponseEntity<?>) {
                ResponseEntity<?> res = (ResponseEntity<?>) result;
                if (res.getStatusCode().is2xxSuccessful() && res.getBody() instanceof Resource) {
                    downloadRecord.setIsSuccess(true);
                    log.info("安装包下载成功");
                } else {
                    downloadRecord.setIsSuccess(false);
                    log.error("安装包下载失败");
                }
            } else {
                downloadRecord.setIsSuccess(false);
                log.error("安装包下载失败，返回结果不是ResponseEntity");
            }

            // 设置下载时间
            downloadRecord.setDownloadTime(LocalDateTime.now());
            log.info("设置下载时间: {}", downloadRecord.getDownloadTime());

            // 插入记录到数据库
            downloadService.addDownloadRecord(downloadRecord);
            log.info("下载记录已插入数据库");

        }

        // 其他带有注解的方法
        return joinPoint.proceed();
    }
}

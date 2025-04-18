package com.aoyukmt.service.website.service;

/**
 * @InterfaceName：MailService
 * @Author: aoyu
 * @Date: 2025/4/18 下午2:33
 * @Description:
 */

public interface MailService {

    /**
     * 发送邮件服务
     * @param to
     * @param subject
     * @param content
     */
    void send(String to, String subject, String content);

}

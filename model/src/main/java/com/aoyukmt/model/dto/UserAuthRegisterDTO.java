package com.aoyukmt.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：UserAuth
 * @Author: aoyu
 * @Date: 2025-04-05 17:27
 * @Description: 用户认证信息类
 */

@Data
public class UserAuthRegisterDTO {
    /**
     * 关联的用户ID
     */
    private Long uid;

    /**
     * 用户名(登录用)
     */
    private String username;

    /**
     * 用户登录密码
     */
    private String password;


}

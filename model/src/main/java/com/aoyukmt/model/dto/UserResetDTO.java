package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：UserResetDTO
 * @Author: aoyu
 * @Date: 2025-04-17 10:01
 * @Description: 用户重置密码DTO
 */

@Data
public class UserResetDTO {

    /**
     * 原密码
     */
    private String originalPassword;

    /**
     * 新密码
     */
    private String newPassword;

}

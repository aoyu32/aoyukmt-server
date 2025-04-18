package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：UserBindEmailDTO
 * @Author: aoyu
 * @Date: 2025-04-17 11:38
 * @Description: 用户绑定邮箱的参数
 */

@Data
public class UserBindEmailDTO {

    /**
     * 邮箱验证码
     */
    private String code;

    /**
     * 邮箱
     */
    private String email;

}

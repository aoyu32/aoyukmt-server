package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：UserLoginDTO
 * @Author: aoyu
 * @Date: 2025-04-09 11:08
 * @Description: 封装用户登录时需要查询的数据
 */
@Data
public class UserLoginDTO {
    /**
     * 用户基本信息
     */
    private UserInfoDTO userInfoDTO;

    /**
     * 用户登录密码
     */
    private String password;
}

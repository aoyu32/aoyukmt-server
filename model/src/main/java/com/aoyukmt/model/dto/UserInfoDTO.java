package com.aoyukmt.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：UserInfoDTO
 * @Author: aoyu
 * @Date: 2025-04-08 10:52
 * @Description: 封装用户信息的DTO
 */

@Data
public class UserInfoDTO {

    private Long uid;
    private String username;
    private String nickname;
    private String email;
    private String avatar;
    private Integer gender;
    private String bio;
    private Integer activeStatus;
    private LocalDateTime registrationTime;
    private String ipInfo;

}

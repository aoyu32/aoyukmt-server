package com.aoyukmt.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    /**
     * 用户uid
     */
    private Long uid;
    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像url
     */
    private String avatar;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 简介
     */
    private String bio;

    /**
     * 在线状态
     */
    private Integer activeStatus;

    /**
     * 注册事件
     */
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:SS")
    private LocalDateTime registrationTime;

    /**
     * ip信息
     */
    private String ipInfo;

}

package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：UserUpdateReqVO
 * @Author: aoyu
 * @Date: 2025-04-15 16:36
 * @Description: 用户更新信息请求实体
 */

@Data
public class UserUpdateDTO {

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户性别
     */
    private String gender;

    /**
     * 用户简介
     */
    private String bio;

}

package com.aoyukmt.model.vo.resp;

import com.aoyukmt.model.dto.UserInfoDTO;
import com.google.gson.JsonObject;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName：UserLoginRespVO
 * @Author: aoyu
 * @Date: 2025-04-07 15:02
 * @Description: 封装返回的登录信息VO
 */

@Data
public class UserLoginRespVO {

    /**
     * 用户信息
     */
    private UserInfoDTO userData;

    /**
     *认证token
     */
    private String token;

}

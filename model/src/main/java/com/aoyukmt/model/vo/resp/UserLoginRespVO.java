package com.aoyukmt.model.vo.resp;

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

    private Long uid;
    private String nickname;
    private String avatar;
    private Integer gender;
    private String bio;
    private Integer activeStatus;
    private LocalDateTime registrationTime;
    private String ipInfo;
    private String token;

}

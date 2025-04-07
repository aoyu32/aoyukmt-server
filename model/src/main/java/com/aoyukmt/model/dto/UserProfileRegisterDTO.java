package com.aoyukmt.model.dto;

import com.google.gson.JsonObject;
import lombok.Data;

/**
 * @ClassName：UserProfile
 * @Author: aoyu
 * @Date: 2025-04-05 17:56
 * @Description: 用户基本信息实体类
 */

@Data
public class UserProfileRegisterDTO {

    /**用户基本信息id**/
    private Long id;

    /** 用户昵称 */
    private String nickname;

    /** 用户头像URL */
    private String avatar;

    /**用户ip信息**/
    private String ipInfo;

}

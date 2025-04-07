package com.aoyukmt.model.vo.req;

import lombok.Data;

/**
 * @ClassName：UserLoginReqVO
 * @Author: aoyu
 * @Date: 2025-04-07 13:58
 * @Description: 封装登录请求参数VO
 */

@Data
public class UserLoginReqVO {

    private String username;

    private String password;

    private String email;

}

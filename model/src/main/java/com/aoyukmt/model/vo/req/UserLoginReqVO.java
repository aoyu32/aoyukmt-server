package com.aoyukmt.model.vo.req;

import com.aoyukmt.common.interfaces.CaptchaVerifiable;
import lombok.Data;

/**
 * @ClassName：UserLoginReqVO
 * @Author: aoyu
 * @Date: 2025-04-07 13:58
 * @Description: 封装登录请求参数VO
 */

@Data
public class UserLoginReqVO implements CaptchaVerifiable {


    /**
     * 滑块验证二次校验码
     */
    private String verifyCode;
    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    @Override
    public String getCaptchaCode() {
        return this.verifyCode;
    }
}

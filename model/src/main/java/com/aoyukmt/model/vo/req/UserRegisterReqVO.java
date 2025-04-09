package com.aoyukmt.model.vo.req;

import com.aoyukmt.common.interfaces.CaptchaVerifiable;
import lombok.Data;

/**
 * @ClassName：UserRegisterDTO
 * @Author: aoyu
 * @Date: 2025-04-04 16:11
 * @Description: 用户注册dto
 */

@Data
public class UserRegisterReqVO implements CaptchaVerifiable {

    /**
     * 滑块验证二次校验码
     */
    private String verifyCode;

    /*
     * 用户名
     * */
    private String username;

    /**
     * 密码
     */
    private String password;


    @Override
    public String getCaptchaCode() {
        return this.verifyCode;
    }
}

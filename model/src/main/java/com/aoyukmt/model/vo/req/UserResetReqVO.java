package com.aoyukmt.model.vo.req;

import com.aoyukmt.common.interfaces.CaptchaVerifiable;
import lombok.Data;

/**
 * @ClassName：UserResetReqVO
 * @Author: aoyu
 * @Date: 2025-04-22 16:19
 * @Description: 用户重置密码请求参数VO
 */

@Data
public class UserResetReqVO implements CaptchaVerifiable {

    /**
     * 滑块验证码
     */
    private String verifyCode;

    /**
     * 邮箱验证码
     */
    private String emailVerifyCode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 新密码
     */
    private String newPassword;

    @Override
    public String getCaptchaCode() {
        return this.verifyCode;
    }
}

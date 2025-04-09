package com.aoyukmt.common.interfaces;

/**
 * @InterfaceName：CaptchaVerifiable
 * @Author: aoyu
 * @Date: 2025/4/9 下午9:28
 * @Description: 需要二次验证验证码的接口
 */

public interface CaptchaVerifiable {

    /**
     * 获取二次校验验证码
     * @return 二次校验验证码
     */
    String getCaptchaCode();

}

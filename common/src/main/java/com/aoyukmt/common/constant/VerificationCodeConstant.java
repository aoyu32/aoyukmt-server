package com.aoyukmt.common.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName：VerificationCodeConstant
 * @Author: aoyu
 * @Date: 2025-04-22 23:29
 * @Description: 邮箱验证码相关常量
 */

public class VerificationCodeConstant {

    //绑定邮箱
    public static final String BINDING_VERIFICATION_CODE = "binding";

    //重置密码
    public static final String RESET_VERIFICATION_COde = "reset";


    public static Boolean isContains(String value){
        Set<String> VERIFICATION_CODE_TYPE_SET = Set.of(BINDING_VERIFICATION_CODE,RESET_VERIFICATION_COde);
        return VERIFICATION_CODE_TYPE_SET.contains(value);
    }


}

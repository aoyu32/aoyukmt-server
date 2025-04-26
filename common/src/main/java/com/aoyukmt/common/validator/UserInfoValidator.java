package com.aoyukmt.common.validator;

import com.aoyukmt.common.annotation.UserInfoValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @ClassName：UserInfoValidator
 * @Author: aoyu
 * @Date: 2025-04-16 10:20
 * @Description: 用户信息数据校验器
 */

public class UserInfoValidator implements ConstraintValidator<UserInfoValidation,Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}

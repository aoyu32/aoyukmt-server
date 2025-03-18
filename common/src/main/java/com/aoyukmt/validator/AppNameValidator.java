package com.aoyukmt.validator;

import com.aoyukmt.annotation.AppNameValidation;
import com.aoyukmt.common.constant.ValidationConstant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @ClassName：AppNameValidator
 * @Author: aoyu
 * @Date: 2025-03-18 11:50
 * @Description: 应用名称格式数据校验器
 */

public class AppNameValidator implements ConstraintValidator<AppNameValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^aoyukmt-\\d+\\.\\d+\\.\\d+\\.(zip|exe)$";
        if (!Pattern.matches(regex, s)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ValidationConstant.APP_NAME_FORMAT_ERROR).addConstraintViolation();
            return false;
        }

        return true;
    }
}

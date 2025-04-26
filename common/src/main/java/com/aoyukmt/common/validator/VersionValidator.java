package com.aoyukmt.common.validator;

import com.aoyukmt.common.annotation.VersionValidation;
import com.aoyukmt.common.constant.ValidationConstant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @ClassName：VersionValidator
 * @Author: aoyu
 * @Date: 2025-03-17 14:33
 * @Description: 版本号数据格式校验
 */

public class VersionValidator implements ConstraintValidator<VersionValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //版本号正则
        String regex = "^\\d+\\.\\d+\\.\\d+$";
        if (!Pattern.matches(regex, s)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ValidationConstant.VERSION_FORMAT_ERROR).addConstraintViolation();
            return false;
        }
        return true;
    }
}

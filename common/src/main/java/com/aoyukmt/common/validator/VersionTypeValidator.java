package com.aoyukmt.common.validator;

import com.aoyukmt.common.annotation.VersionTypeValidation;
import com.aoyukmt.common.constant.ValidationConstant;
import com.aoyukmt.common.constant.VersionTypeConstant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

/**
 * @ClassName：VersionTypeValidator
 * @Author: aoyu
 * @Date: 2025-03-18 11:35
 * @Description: 版本类型数据校验器
 */

public class VersionTypeValidator implements ConstraintValidator<VersionTypeValidation,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(!Set.of(VersionTypeConstant.LATEST_VERSION,VersionTypeConstant.HISTORY_VERSION).contains(s)){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ValidationConstant.UNKNOWN_VERSION_TYPE).addConstraintViolation();
            return false;
        }
        return true;
    }
}

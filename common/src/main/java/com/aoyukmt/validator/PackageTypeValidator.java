package com.aoyukmt.validator;

import com.aoyukmt.annotation.PackageTypeValidation;
import com.aoyukmt.common.constant.DownloadConstants;
import com.aoyukmt.common.constant.ValidationConstant;
import com.aoyukmt.common.constant.VersionTypeConstant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

/**
 * @ClassName：PackageTypeValidator
 * @Author: aoyu
 * @Date: 2025-03-18 11:03
 * @Description: 安装包类型校验
 */

public class PackageTypeValidator implements ConstraintValidator<PackageTypeValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(!Set.of(DownloadConstants.INSTALLER,DownloadConstants.ZIP).contains(s)){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ValidationConstant.UNKNOWN_PACKAGE_TYPE).addConstraintViolation();
            return false;
        }
        return true;
    }
}

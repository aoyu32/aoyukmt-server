package com.aoyukmt.common.annotation;

/*
 * 安装包类型校验注解
 */

import com.aoyukmt.common.validator.PackageTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PackageTypeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PackageTypeValidation {

    String message() default "不支持的安装包类型";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

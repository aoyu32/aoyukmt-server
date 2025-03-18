package com.aoyukmt.annotation;

import com.aoyukmt.validator.AppNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 应用名称（全名称）数据校验
 */

@Documented
@Constraint(validatedBy = AppNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface AppNameValidation {

    String message() default "应用名称格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

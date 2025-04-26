package com.aoyukmt.common.annotation;

import com.aoyukmt.common.validator.VersionTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 版本类型校验注解
 */
@Documented
@Constraint(validatedBy = VersionTypeValidator.class)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionTypeValidation {

    String message() default "版本类型错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

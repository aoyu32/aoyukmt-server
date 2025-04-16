package com.aoyukmt.annotation;

import com.aoyukmt.validator.UserInfoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserInfoValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)

public @interface UserInfoValidation {
    String message() default "用户信息不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

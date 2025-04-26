package com.aoyukmt.common.annotation;

import com.aoyukmt.common.validator.VersionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 版本号校验注解
 */
@Documented
@Constraint(validatedBy = VersionValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface VersionValidation {

    String message() default "版本号格式错误";

    Class<?>[] groups() default {}; // 用于分组校验

    Class<? extends Payload>[] payload() default {}; // 负载信息（通常用于传递元数据）

}

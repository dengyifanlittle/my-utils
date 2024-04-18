package com.littledyf.annotation.valid;

/**
 * @Author dengyifan
 * @create 2024/4/18 16:37
 * @description
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EnumValidator.class})
public @interface ValidEnum {

    // 默认错误消息
    String message() default "枚举值不合法";

    // 分组
    Class<?>[] groups() default {};

    // 负载
    Class<? extends Payload>[] payload() default {};

    // 枚举类
    Class<? extends Enum<?>> enumClass();

    // 枚举方法
    String enumMethod();
}
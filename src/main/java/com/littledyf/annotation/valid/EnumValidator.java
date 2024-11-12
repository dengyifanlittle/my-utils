package com.littledyf.annotation.valid;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @Author dengyifan
 * @create 2024/4/18 16:37
 * @description
 */
@Slf4j
public class EnumValidator implements ConstraintValidator<ValidEnum, Object> {

    private Class<? extends Enum<?>> enumClass;
    private String enumMethod;

    @Override
    public void initialize(ValidEnum enumValue) {
        enumMethod = enumValue.enumMethod();
        enumClass = enumValue.enumClass();
    }

    /**
     * 自定义校验。
     *
     * @param value 枚举值
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return Boolean.TRUE;
        }
        if (enumClass == null || enumMethod == null || ArrayUtils.isEmpty(enumClass.getEnumConstants())) {
            return Boolean.TRUE;
        }

        try {
            Method method = enumClass.getMethod(enumMethod);

            Set codeSet = Sets.newHashSet();
            for (Enum<?> e : enumClass.getEnumConstants()) {
                codeSet.add(method.invoke(e));
            }

            return codeSet.contains(value);
        } catch (Exception e) {
            log.error("validate enum error! enumClass: {}, enumMethod: {}, value: {}", enumClass, enumMethod, value, e);
            return Boolean.TRUE;
        }
    }
}


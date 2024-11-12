package com.littledyf.annotation.dto;

import com.littledyf.annotation.valid.ValidEnum;
import lombok.Data;

/**
 * @Author dengyifan
 * @create 2024/4/19 9:57
 * @description
 */

@Data
public class EnumTestDto {

    @ValidEnum(message = "枚举值不合法", enumClass = TestEnum.class, enumMethod = "getCode")
    private Integer testCode;

    @ValidEnum(message = "枚举值不合法", enumClass = TestEnum.class, enumMethod = "getValue")
    private String testValue;

}

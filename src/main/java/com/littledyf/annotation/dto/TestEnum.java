package com.littledyf.annotation.dto;

/**
 * @Author dengyifan
 * @create 2024/4/19 10:03
 * @description
 */
public enum TestEnum {

    TEST_ONE(1, "test1"),

    TEST_TWO(2, "test2"),

    TEST_THREE(3, "test3");

    private Integer code;

    private String value;

    TestEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

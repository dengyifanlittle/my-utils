package com.littledyf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author dengyifan
 * @create 2023/9/15 15:44
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = false)
// 并不包含所有的json属性
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    // JsonProperty可以将对应的jsonkey指定变量
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("Age")
    private Integer age;

}

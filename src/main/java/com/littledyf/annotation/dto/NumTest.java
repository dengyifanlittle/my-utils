package com.littledyf.annotation.dto;

import com.littledyf.annotation.valid.ValidNum;
import lombok.Data;

@Data
public class NumTest {

    @ValidNum(value = 30, message = "数值不能大于30")
    private Integer num;
}

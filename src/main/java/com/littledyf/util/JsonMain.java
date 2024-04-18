package com.littledyf.util;

import com.github.javafaker.Faker;
import com.littledyf.domain.UserDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * @Author dengyifan
 * @create 2023/9/15 15:46
 * @description
 */
public class JsonMain {
    public static void main(String[] args) throws IOException {
//        BigDecimal num = new BigDecimal("123.0");
//        System.err.println(num.stripTrailingZeros().scale());
        List<UserDto> userDtoList = JsonToolUtil.readJsonArray("C:\\Users\\dengyifan\\Desktop\\test.json", UserDto.class);
        System.out.println(userDtoList);
    }
}

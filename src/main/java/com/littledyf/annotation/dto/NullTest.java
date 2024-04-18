package com.littledyf.annotation.dto;

import com.littledyf.annotation.valid.ValidNull;
import lombok.Data;

@Data
public class NullTest {

    @ValidNull
    private String name;
}

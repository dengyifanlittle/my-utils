package com.littledyf.cqs.domain;

import com.littledyf.cqs.Query;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TestDto implements Serializable, Query<List<TestVo>> {
    private String name;
}

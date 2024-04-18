package com.littledyf.cqs.controller;

import com.littledyf.cqs.Bus;
import com.littledyf.cqs.domain.TestDto;
import com.littledyf.cqs.domain.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/my-test/cqs")
public class CqsController {

    @Resource
    private Bus bus;

    @PostMapping(value = "/query-test")
    public List<TestVo> queryTest(@RequestBody TestDto testDto)  {
        return bus.executeQuery(testDto);
    }
}

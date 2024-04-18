package com.littledyf.annotation.controller;

import com.littledyf.annotation.dto.NumTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/my-test/annotation")
public class AnnotationController {

    @PostMapping(value = "/num")
    public String testNum(@RequestBody @Validated NumTest numTest) {

        System.err.println(numTest.getNum());
        return "success";
    }

    @PostMapping(value = "/value")
    public String testValue(@RequestBody @Validated NumTest numTest) {
        System.err.println(numTest.getNum());
        return "success";
    }
}

package com.littledyf.cqs.query;

import com.littledyf.cqs.QueryHandler;
import com.littledyf.cqs.domain.TestDto;
import com.littledyf.cqs.domain.TestVo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class TestQueryHandler implements QueryHandler<List<TestVo>, TestDto> {

    @Override
    public List<TestVo> handle(TestDto testDto) {

        List<TestVo> testVos = new ArrayList<>();
        TestVo testVo = new TestVo();
        testVo.setNameVo(testDto.getName());

        testVos.add(testVo);
        return testVos;
    }
}

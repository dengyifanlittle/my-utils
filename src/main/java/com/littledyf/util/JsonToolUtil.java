package com.littledyf.util;

import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author dengyifan
 * @create 2023/9/15 15:32
 * @description
 */
@Slf4j
public class JsonToolUtil {

    public static <T> List<T> readJsonArray(String fileName, Class<T> clazz) throws IOException {
        Path f = Paths.get(fileName);
        // 判断文件是否存在
        if (!Files.exists(f)) {
            log.error(String.format("file[%s] not exists", fileName));
            return Collections.emptyList();
        }
        List<String> fileList =  Files.readAllLines(f);
        // 判断文件是否是空文件
        if (fileList.isEmpty()) {
            log.warn(String.format("file[%s] is empty", fileName));
            return Collections.emptyList();
        }
        // 将读取的json文件数据转换为对应的bean
        List<T> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(String it : fileList){
            list.add(mapper.readValue(it, clazz));
        }
        return list;
    }
}

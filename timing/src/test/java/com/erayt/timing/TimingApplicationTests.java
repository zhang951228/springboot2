package com.erayt.timing;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class TimingApplicationTests {

    @Value("${erayt.mergeFilePath}")
    private String mergeFilePath;
    @Value("${erayt.importFilePath}")
    private String importFilePath;


    @Test
    void contextLoads() {
        System.out.println("11");
    }

}

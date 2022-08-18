package com.example.sofabootconsumer;

import com.example.sofabootconsumer.service.IConsumeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SofaBootConsumerApplicationTests {

    @Resource
    private  IConsumeServiceImpl iConsumeService;
    @Test
    void contextLoads() {
        iConsumeService.consume();
//        IConsumeServiceImpl iConsumeService = new IConsumeServiceImpl();
//        iConsumeService.consume();
    }

}

package com.ssm.notebook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.ssm.notebook.mapper")
public class NotebookApplicationTests {

    @Test
    public void contextLoads() {
    }

}

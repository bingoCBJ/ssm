package com.ssm.notebook.testAll;

import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class TestMd5 {

    //@Test
    public void TestMd5() throws IOException {
        File file = new File("C:\\Users\\84393\\Desktop\\temp\\报名照片 - 副本.jpg");
        InputStream inputStream = new FileInputStream(file);
        String str = DigestUtils.md5DigestAsHex(inputStream);
        System.out.println(str);
        File file01 = new File("C:\\Users\\84393\\Desktop\\temp\\picture\\re_creators.jpg");
        InputStream inputStream01 = new FileInputStream(file01);
        String str01 = DigestUtils.md5DigestAsHex(inputStream01);
        System.out.println(str01);
    }
}

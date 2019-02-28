package com.ssm.notebook.testAll;

import com.ssm.notebook.mapper.FileDao;
import com.ssm.notebook.mapper.TagDao;
import com.ssm.notebook.model.FileInfo;
import com.ssm.notebook.model.Tag;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

public class TestDao {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileDao fileDao;

    @Autowired
    private TagDao tagDao;

    //
    public void testFileDao(){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setUser_id(Integer.parseInt("2"));
        fileInfo.setFile_name("re_creators.jpg");
        fileInfo.setPath("C:\\Users\\84393\\Desktop\\temp\\picture\\re_creators.jpg");
        fileInfo.setMd5_code("53e445d25cd02cbeb2cc4a2835e1c9d8");
        fileInfo.setCreate_time(new Date());
        fileDao.addFile(fileInfo);
        System.out.println(""+fileInfo.getId());

    }

    //@Test
    public void testTagDao(){
        Tag tag = new Tag();
        tag.setName("ceshi");
        tagDao.addTag(tag);
        System.out.println(""+tag.getId());
    }

   // @Test
    public void testFile(){
        File file = new File("D:\\home\\files\\123.jpg");
        logger.info(file.getName());
    }
}

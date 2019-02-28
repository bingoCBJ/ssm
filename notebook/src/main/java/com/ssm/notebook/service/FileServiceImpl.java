package com.ssm.notebook.service;

import com.ssm.notebook.mapper.FileDao;
import com.ssm.notebook.model.FileInfo;
import com.ssm.notebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fileService")
public class FileServiceImpl implements FileService{

    @Autowired
    private FileDao fileDao;


    @Override
    public List<FileInfo> getFileByUser(User user) {
        return fileDao.getFileByUser(user);
    }

    @Override
    public FileInfo getFileById(FileInfo file) {
        return fileDao.getFileById(file);
    }

    @Override
    public void addFile(FileInfo file) {
        fileDao.addFile(file);
    }
}

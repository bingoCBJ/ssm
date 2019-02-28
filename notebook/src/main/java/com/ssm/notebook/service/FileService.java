package com.ssm.notebook.service;

import com.ssm.notebook.model.FileInfo;
import com.ssm.notebook.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileService {


    List<FileInfo> getFileByUser(@Param("user") User user);

    FileInfo getFileById(@Param("file")FileInfo file);

    void addFile(@Param("file")FileInfo file);

}

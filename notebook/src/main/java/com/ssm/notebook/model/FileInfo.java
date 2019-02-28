package com.ssm.notebook.model;

import java.io.Serializable;
import java.util.Date;

public class FileInfo  implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Integer id;
    private Integer user_id;
    private String file_name;
    private String path;
    private String md5_code;
    private String status;
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMd5_code() {
        return md5_code;
    }

    public void setMd5_code(String md5_code) {
        this.md5_code = md5_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", file_name='" + file_name + '\'' +
                ", path='" + path + '\'' +
                ", md5_code='" + md5_code + '\'' +
                ", status='" + status + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}

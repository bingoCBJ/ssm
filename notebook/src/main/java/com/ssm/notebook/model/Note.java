package com.ssm.notebook.model;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    private static final long serialVersionUID = 8660235356698502882L;

    private Integer id;
    private Integer tag_id;
    private String contents;
    private String title;
    private String url;
    private String status;
    private Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        return "Note{" +
                "id=" + id +
                ", tag_id=" + tag_id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}

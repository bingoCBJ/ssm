package com.ssm.notebook.service;

import com.ssm.notebook.model.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getAllTag();

    Tag getTagById(Tag tag);

    void addTag(Tag tag);

}

package com.ssm.notebook.mapper;

import com.ssm.notebook.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface TagDao {

    List<Tag> getAllTag();

    Tag getTagById(@Param("tag") Tag tag);

    void addTag(@Param("tag") Tag tag);

}

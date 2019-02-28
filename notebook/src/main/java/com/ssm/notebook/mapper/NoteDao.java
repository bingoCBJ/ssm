package com.ssm.notebook.mapper;

import com.ssm.notebook.model.Note;
import com.ssm.notebook.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface NoteDao {

    List<Note> getAllNote();

    List<Note> getNoteByTag(@Param("tag")Tag tag);

    Note getNoteById(@Param("note")Note note);

    void addNote(@Param("note")Note note);

}

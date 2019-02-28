package com.ssm.notebook.service;

import com.ssm.notebook.model.Note;
import com.ssm.notebook.model.Tag;

import java.util.List;

public interface NoteService {

    List<Note> getAllNote();

    List<Note> getNoteByTag(Tag tag);

    Note getNoteById(Note note);

    void addNote(Note note);

}

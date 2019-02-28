package com.ssm.notebook.service;

import com.ssm.notebook.mapper.NoteDao;
import com.ssm.notebook.model.Note;
import com.ssm.notebook.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteDao noteDao;

    @Override
    @Cacheable(cacheNames = "allNotes")
    public List<Note> getAllNote() {
        System.out.println("使用数据库查询allNotes");
        return noteDao.getAllNote();
    }

    @Override
    @Cacheable(cacheNames = "someNotes",key = "#tag.id")
    public List<Note> getNoteByTag(Tag tag) {
        System.out.println("使用数据库查询someNotes");
        return noteDao.getNoteByTag(tag);
    }

    @Override
    @Cacheable(cacheNames = "note",key = "#note.id")
    public Note getNoteById(Note note) {
        System.out.println("使用数据库查询oneNote");
        return noteDao.getNoteById(note);
    }

    @Override
    @CacheEvict(cacheNames = {"allNotes","someNotes"}, allEntries = true)
    public void addNote(Note note) {
        noteDao.addNote(note);
    }
}

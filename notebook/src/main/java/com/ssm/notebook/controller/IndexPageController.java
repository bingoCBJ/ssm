package com.ssm.notebook.controller;

import com.google.gson.Gson;
import com.ssm.notebook.model.Note;
import com.ssm.notebook.model.Tag;
import com.ssm.notebook.service.NoteService;
import com.ssm.notebook.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/index")
public class IndexPageController {
    Logger logger = LoggerFactory.getLogger(getClass());
    private Gson gson = new Gson();

    @Autowired
    private TagService tagService;
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/getTags",method = RequestMethod.GET)
    public String getTags(){
        logger.info("请求/index/getTags接口");
        List<Tag> tagList = tagService.getAllTag();
        String jsonStr = gson.toJson(tagList);
        return jsonStr;
    }

    @RequestMapping(value = "/getTagById",method = RequestMethod.GET)
    public String getTagById(@RequestParam("tag_id")int tag_id){
        logger.info("请求/index/getTagById接口");
        Tag tag = new Tag();
        tag.setId(tag_id);
        tag = tagService.getTagById(tag);
        String jsonStr = gson.toJson(tag);
        return jsonStr;
    }

    @RequestMapping(value = "/addTag",method = RequestMethod.POST)
    public String addTag(@RequestParam("tagName") String tagName){
        logger.info("请求/index/addTag接口");
        Tag tag = new Tag();
        tag.setName(tagName);
        tagService.addTag(tag);
        String jsonStr = "{ \"num\": \""+ tag.getId() +"\" }";
        return jsonStr;
    }

    @RequestMapping(value = "/getAllNote",method = RequestMethod.GET)
    public String getAllNote(){
        logger.info("请求/index/getAllNote接口");
        List<Note> noteList = noteService.getAllNote();
        String jsonStr =  gson.toJson(noteList);
        return jsonStr;
    }

    @RequestMapping(value = "/getNoteByTag",method = RequestMethod.GET)
    public String getNoteByTag(@RequestParam("tag_id") int tag_id){
        logger.info("请求/index/getNoteByTag接口");
        Tag tag = new Tag();
        tag.setId(tag_id);
        List<Note> noteList = noteService.getNoteByTag(tag);
        String jsonStr =  gson.toJson(noteList);
        return jsonStr;
    }

    @RequestMapping(value = "/getNoteById",method = RequestMethod.GET)
    public String getNoteById(@RequestParam("note_id") int note_id){
        logger.info("请求/index/getNoteById接口");
        Note note = new Note();
        note.setId(note_id);
        note = noteService.getNoteById(note);
        String jsonStr =  gson.toJson(note);
        return jsonStr;
    }

    @RequestMapping(value = "/addNote",method = RequestMethod.POST)
    public String addNote( @RequestParam("title") String title,
                           @RequestParam("tag_id") int tag_id,
                           @RequestParam("url") String url,
                           @RequestParam("content") String content){
        logger.info("请求/index/addNote接口");
        Note note = new Note();
        note.setTitle(title);
        note.setTag_id(tag_id);
        note.setUrl(url);
        note.setContents(content);
        note.setCreate_time(new Date());
        noteService.addNote(note);
        String jsonStr = "{ \"num\":\""+ note.getId() +"\", \"create_time\":\""+note.getCreate_time()+"\" }";
        return jsonStr;
    }
}

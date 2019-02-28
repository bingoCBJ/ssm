package com.ssm.notebook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@CrossOrigin
@Controller
public class HtmlController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/html/{filename}",method = RequestMethod.GET)
    public String getHtml(@PathVariable("filename") String filename){
        logger.info("访问"+filename+".html页面");
        return filename;
    }

    @RequestMapping(value = "/html/refresh",method = RequestMethod.POST)
    @CacheEvict(cacheNames = {"allNotes","someNotes","allTags","oneTag"}, allEntries = true)
    public String refresh(@RequestParam("filename") String filename){
        logger.info("刷新"+filename+"html页面");
        return filename;
    }

}

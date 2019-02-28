package com.ssm.notebook.service;

import com.ssm.notebook.mapper.TagDao;
import com.ssm.notebook.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService{
    @Autowired
    private TagDao tagDao;

    @Override
    @Cacheable(cacheNames = "allTags")
    public List<Tag> getAllTag() {
        return tagDao.getAllTag();
    }

    @Override
    @Cacheable(cacheNames = "oneTag",key = "#tag.id")
    public Tag getTagById(Tag tag) {
        return tagDao.getTagById(tag);
    }

    @Override
    @CacheEvict(cacheNames = {"allTags","oneTag"},allEntries = true)
    public void addTag(Tag tag) { tagDao.addTag(tag); }
}

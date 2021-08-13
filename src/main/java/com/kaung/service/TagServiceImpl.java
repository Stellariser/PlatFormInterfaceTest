package com.kaung.service;

import com.kaung.mapper.SceneMapper;
import com.kaung.mapper.TagMapper;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagServiceImpl implements TagService{
    @Autowired
    private TagMapper tagMapper;

    public void setTagMapper(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }
    @Override
    public int addTag(Tag Tag) {
        return tagMapper.addTag(Tag);
    }

    @Override
    public int deleteTagById(int id) {
        return tagMapper.deleteTagById(id);
    }

    @Override
    public int updateTag(Tag Tag) {
        return tagMapper.updateTag(Tag);
    }
    @Override
    public Tag queryTagById(int id) {
        return tagMapper.queryTagById(id);
    }

    @Override
    public List<Tag> queryAllTag() {
        return tagMapper.queryAllTag();
    }

    @Override
    public Tag queryTagByName(String name) {
        return null;
    }

    @Override
    public List<Tag> queryTagVague(QueryInfo queryInfo) {
        return null;
    }

    @Override
    public List<Tag> queryTag() {
        return tagMapper.queryTag();
    }
}

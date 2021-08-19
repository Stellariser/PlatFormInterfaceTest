package com.kaung.service;

import com.kaung.pogo.TagToFrame;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TagToFrameServiceImpl implements TagToFrameService{

    @Autowired
    private com.kaung.mapper.TagToFrameMapper TagToFrameMapper;
    public void setTagToFrameMapper(com.kaung.mapper.TagToFrameMapper TagToFrameMapper) {
        this.TagToFrameMapper = TagToFrameMapper;
    }

    @Override
    public int addTagToFrame(TagToFrame TagToFrame) {
        return TagToFrameMapper.addTagToFrame(TagToFrame);
    }

    @Override
    public int deleteTagToFrameById(int id) {
        return TagToFrameMapper.deleteTagToFrameById(id);
    }

    @Override
    public int updateTagToFrame(TagToFrame TagToFrame) {
        return TagToFrameMapper.updateTagToFrame(TagToFrame);
    }

    @Override
    public TagToFrame queryTagToFrameById(int id) {
        return TagToFrameMapper.queryTagToFrameById(id);
    }

    @Override
    public List<TagToFrame> queryAllTagToFrame() {
        return TagToFrameMapper.queryAllTagToFrame();
    }

    @Override
    public TagToFrame queryTagToFrameByName(String name) {
        return TagToFrameMapper.queryTagToFrameByName(name);
    }

    @Override
    public int getLastInsert() {
        return TagToFrameMapper.getLastInsert();
    }
}

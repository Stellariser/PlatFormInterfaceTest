package com.kaung.service;

import com.kaung.mapper.FrameProperityMapper;
import com.kaung.mapper.FrameToClassMapper;
import com.kaung.pogo.FrameToClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FrameToClassServiceImpl implements FrameToClassService{
    @Autowired
    private FrameToClassMapper FrameToClassMapper;
    public void setFrameToClassMapper(FrameToClassMapper frameToClassMapper) {
        this.FrameToClassMapper = frameToClassMapper;
    }

    @Override
    public int addFrameToClass(FrameToClass FrameToClass) {
        return FrameToClassMapper.addFrameToClass(FrameToClass);
    }

    @Override
    public int deleteFrameToClassById(int id) {
        return FrameToClassMapper.deleteFrameToClassById(id);
    }

    @Override
    public int updateFrameToClass(FrameToClass FrameToClass) {
        return FrameToClassMapper.updateFrameToClass(FrameToClass);
    }

    @Override
    public FrameToClass queryFrameToClassById(int id) {
        return FrameToClassMapper.queryFrameToClassById(id);
    }

    @Override
    public List<FrameToClass> queryAllFrameToClass() {
        return FrameToClassMapper.queryAllFrameToClass();
    }

    @Override
    public FrameToClass queryFrameToClassByName(String name) {
        return FrameToClassMapper.queryFrameToClassByName(name);
    }

    @Override
    public int getLastInsert() {
        return FrameToClassMapper.getLastInsert();
    }
}

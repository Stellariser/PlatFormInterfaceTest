package com.kaung.service;

import com.kaung.mapper.FrameLabelMapper;
import com.kaung.pogo.FrameLabel;
import com.kaung.pogo.LabelQueryInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FrameLabelServiceImpl implements FrameLabelService{

    @Autowired
    private FrameLabelMapper frameLabelMapper;

    public void setFrameLabelMapper(FrameLabelMapper frameLabelMapper) {
        this.frameLabelMapper = frameLabelMapper;
    }

    @Override
    public int addFrameLabel(FrameLabel FrameLabel) {
        return frameLabelMapper.addFrameLabel(FrameLabel);
    }

    @Override
    public int deleteFrameLabelById(int id) {
        return frameLabelMapper.deleteFrameLabelById(id);
    }

    @Override
    public int updateFrameLabel(FrameLabel FrameLabel) {
        return frameLabelMapper.updateFrameLabel(FrameLabel);
    }

    @Override
    public FrameLabel queryFrameLabelById(int id) {
        return frameLabelMapper.queryFrameLabelById(id);
    }

    @Override
    public List<FrameLabel> queryAllFrameLabel() {
        return frameLabelMapper.queryAllFrameLabel();
    }

    @Override
    public List<FrameLabel> queryFrameLabelByName(LabelQueryInfo LabelQueryInfo) {
        return frameLabelMapper.queryFrameLabelByName(LabelQueryInfo);
    }
}

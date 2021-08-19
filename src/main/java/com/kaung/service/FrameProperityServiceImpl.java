package com.kaung.service;

import com.kaung.mapper.FrameProperityMapper;
import com.kaung.pogo.FrameProperity;
import com.kaung.vo.FrameAddForm;
import com.kaung.vo.ProperityQueryInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FrameProperityServiceImpl implements FrameProperityService {

    @Autowired
    private FrameProperityMapper frameProperityMapper;

    public void setFrameProperityMapper(FrameProperityMapper frameProperityMapper) {
        this.frameProperityMapper = frameProperityMapper;
    }

    @Override
    public int addFrameProperity(FrameAddForm FrameAddForm) {
        return frameProperityMapper.addFrameProperity(FrameAddForm);
    }

    @Override
    public int deleteFrameProperityById(int id) {
        return frameProperityMapper.deleteFrameProperityById(id);
    }

    @Override
    public int updateFrameProperity(FrameProperity FrameProperity) {
        return frameProperityMapper.updateFrameProperity(FrameProperity);
    }

    @Override
    public FrameProperity queryFrameProperityById(int id) {
        return frameProperityMapper.queryFrameProperityById(id);
    }

    @Override
    public List<FrameProperity> queryAllFrameProperity() {
        return frameProperityMapper.queryAllFrameProperity();
    }

    @Override
    public FrameProperity queryFrameProperityByName(String name) {
        return frameProperityMapper.queryFrameProperityByName(name);
    }

    @Override
    public List<FrameProperity> queryGlobalFrame(ProperityQueryInfo ProperityQueryInfo) {
        return frameProperityMapper.queryGlobalFrame(ProperityQueryInfo);
    }

    @Override
    public int getLastInsert() {
        return frameProperityMapper.getLastInsert();
    }
}

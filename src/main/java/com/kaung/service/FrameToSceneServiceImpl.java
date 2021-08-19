package com.kaung.service;

import com.kaung.mapper.FrameToClassMapper;
import com.kaung.mapper.FrameToSceneMapper;
import com.kaung.pogo.FrameToScene;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FrameToSceneServiceImpl implements FrameToSceneService{
    @Autowired
    private com.kaung.mapper.FrameToSceneMapper FrameToSceneMapper;
    public void setFrameToSceneMapper(com.kaung.mapper.FrameToSceneMapper FrameToSceneMapper) {
        this.FrameToSceneMapper = FrameToSceneMapper;
    }


    @Override
    public int addFrameToScene(FrameToScene FrameToScene) {
        return FrameToSceneMapper.addFrameToScene(FrameToScene);
    }

    @Override
    public int deleteFrameToSceneById(int id) {
        return FrameToSceneMapper.deleteFrameToSceneById(id);
    }

    @Override
    public int updateFrameToScene(FrameToScene FrameToScene) {
        return FrameToSceneMapper.addFrameToScene(FrameToScene);
    }

    @Override
    public FrameToScene queryFrameToSceneById(int id) {
        return FrameToSceneMapper.queryFrameToSceneById(id);
    }

    @Override
    public List<FrameToScene> queryAllFrameToScene() {
        return FrameToSceneMapper.queryAllFrameToScene();
    }

    @Override
    public FrameToScene queryFrameToSceneByName(String name) {
        return FrameToSceneMapper.queryFrameToSceneByName(name);
    }

    @Override
    public int getLastInsert() {
        return FrameToSceneMapper.getLastInsert();
    }
}

package com.kaung.service;

import com.kaung.mapper.SceneCountMapper;
import com.kaung.pogo.SceneCount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SceneCountServiceImpl implements SceneCountService{
    @Autowired
    private SceneCountMapper sceneCountMapper;

    public void setSceneCountMapper(SceneCountMapper sceneCountMapper) {
        this.sceneCountMapper = sceneCountMapper;
    }

    @Override
    public List<SceneCount> getSceneCount() {
        return sceneCountMapper.getSceneCount();
    }
}

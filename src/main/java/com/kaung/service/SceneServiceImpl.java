package com.kaung.service;

import com.kaung.mapper.SceneMapper;
import com.kaung.pogo.Scene;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SceneServiceImpl implements SceneService{

    @Autowired
    private SceneMapper sceneMapper;

    public void setSceneMapper(SceneMapper sceneMapper) {
        this.sceneMapper = sceneMapper;
    }

    @Override
    public int addScene(Scene Scene) {
        return sceneMapper.addScene(Scene);
    }

    @Override
    public int deleteSceneById(int id) {
        return sceneMapper.deleteSceneById(id);
    }

    @Override
    public int updateScene(Scene Scene) {
        return sceneMapper.updateScene(Scene);
    }

    @Override
    public Scene querySceneById(int id) {
        return sceneMapper.querySceneById(id);
    }

    @Override
    public List<Scene> queryAllScene() {
        return sceneMapper.queryAllScene();
    }

    @Override
    public Scene querySceneByName(String name) {
        return sceneMapper.querySceneByName(name);
    }
}

package com.kaung.service;

import com.kaung.pogo.Scene;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SceneService {
    int addScene(Scene Scene);

    int deleteSceneById(int id);

    int updateScene(Scene Scene);

    Scene querySceneById(int id);

    List<Scene> queryAllScene();

    Scene querySceneByName(String name);
}

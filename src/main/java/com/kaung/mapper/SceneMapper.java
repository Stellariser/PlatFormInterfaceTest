package com.kaung.mapper;

import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.Scene;
import com.kaung.pogo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SceneMapper {
    int addScene(Scene Scene);

    int deleteSceneById(int id);

    int updateScene(Scene Scene);

    Scene querySceneById(int id);

    List<Scene> queryAllScene();

    Scene querySceneByName(String name);

    List<Scene> querySceneVague(QueryInfo queryInfo);

    List<Scene> queryScene();
}

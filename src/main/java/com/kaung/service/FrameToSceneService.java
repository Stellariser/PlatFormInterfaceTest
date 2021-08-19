package com.kaung.service;

import com.kaung.pogo.FrameToClass;
import com.kaung.pogo.FrameToScene;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FrameToSceneService {
    int addFrameToScene(FrameToScene FrameToScene);

    int deleteFrameToSceneById(int id);

    int updateFrameToScene(FrameToScene FrameToScene);

    FrameToScene queryFrameToSceneById(int id);

    List<FrameToScene> queryAllFrameToScene();

    FrameToScene queryFrameToSceneByName(String name);

    int getLastInsert();
}

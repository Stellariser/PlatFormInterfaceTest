package com.kaung.mapper;

import com.kaung.pogo.FrameToClass;
import com.kaung.pogo.FrameToScene;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface FrameToSceneMapper {
    int addFrameToScene(FrameToScene FrameToScene);

    int deleteFrameToSceneById(int id);

    int updateFrameToScene(FrameToScene FrameToScene);

    FrameToScene queryFrameToSceneById(int id);

    List<FrameToScene> queryAllFrameToScene();

    FrameToScene queryFrameToSceneByName(String name);
    int getLastInsert();
}

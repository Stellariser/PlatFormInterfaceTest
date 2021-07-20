package com.kaung.mapper;

import com.kaung.pogo.DatasetToScene;
import com.kaung.pogo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DatasetToSceneMapper {
    int addDatasetToScene(DatasetToScene DatasetToScene);

    int deleteDatasetToSceneById(int id);

    int updateDatasetToScene(DatasetToScene DatasetToScene);

    DatasetToScene queryDatasetToSceneById(int id);

    List<DatasetToScene> queryAllDatasetToScene();

    DatasetToScene queryDatasetToSceneByName(String name);
}

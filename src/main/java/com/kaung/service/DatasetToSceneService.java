package com.kaung.service;

import com.kaung.pogo.DatasetToScene;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DatasetToSceneService {
    int addDatasetToScene(DatasetToScene DatasetToScene);

    int deleteDatasetToSceneById(int id);

    int updateDatasetToScene(DatasetToScene DatasetToScene);

    DatasetToScene queryDatasetToSceneById(int id);

    List<DatasetToScene> queryAllDatasetToScene();

    DatasetToScene queryDatasetToSceneByName(String name);
}

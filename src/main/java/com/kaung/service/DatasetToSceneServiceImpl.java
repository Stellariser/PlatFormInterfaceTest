package com.kaung.service;

import com.kaung.mapper.DatasetToSceneMapper;
import com.kaung.pogo.DatasetToScene;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DatasetToSceneServiceImpl implements DatasetToSceneService{

    @Autowired
    private DatasetToSceneMapper datasetToSceneMapper;

    public void setDatasetToSceneMapper(DatasetToSceneMapper datasetToSceneMapper) {
        this.datasetToSceneMapper = datasetToSceneMapper;
    }

    @Override
    public int addDatasetToScene(DatasetToScene DatasetToScene) {
        return datasetToSceneMapper.addDatasetToScene(DatasetToScene);
    }

    @Override
    public int deleteDatasetToSceneById(int id) {
        return datasetToSceneMapper.deleteDatasetToSceneById(id);
    }

    @Override
    public int updateDatasetToScene(DatasetToScene DatasetToScene) {
        return datasetToSceneMapper.updateDatasetToScene(DatasetToScene);
    }

    @Override
    public DatasetToScene queryDatasetToSceneById(int id) {
        return datasetToSceneMapper.queryDatasetToSceneById(id);
    }

    @Override
    public List<DatasetToScene> queryAllDatasetToScene() {
        return datasetToSceneMapper.queryAllDatasetToScene();
    }

    @Override
    public DatasetToScene queryDatasetToSceneByName(String name) {
        return datasetToSceneMapper.queryDatasetToSceneByName(name);
    }
}

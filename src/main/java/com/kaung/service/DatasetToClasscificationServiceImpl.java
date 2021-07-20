package com.kaung.service;

import com.kaung.mapper.DatasetToClasscificationMapper;
import com.kaung.mapper.DatasetsMapper;
import com.kaung.pogo.Classcification;
import com.kaung.pogo.DatasetToClasscification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DatasetToClasscificationServiceImpl implements DatasetToClasscificationService{


    @Autowired
    private com.kaung.mapper.DatasetToClasscificationMapper DatasetToClasscificationMapper;

    public void setDatasetToClasscificationMapper(com.kaung.mapper.DatasetToClasscificationMapper datasetToClasscificationMapper) {
        this.DatasetToClasscificationMapper = datasetToClasscificationMapper;
    }

    @Override
    public int addDatasetToClasscification(DatasetToClasscification DatasetToClasscification) {
        return DatasetToClasscificationMapper.addDatasetToClasscification(DatasetToClasscification);
    }

    @Override
    public int deleteDatasetToClasscificationById(int id) {
        return DatasetToClasscificationMapper.deleteDatasetToClasscificationById(id);
    }

    @Override
    public int updateDatasetToClasscification(DatasetToClasscification DatasetToClasscification) {
        return DatasetToClasscificationMapper.updateDatasetToClasscification(DatasetToClasscification);
    }

    @Override
    public DatasetToClasscification queryDatasetToClasscificationById(int id) {
        return DatasetToClasscificationMapper.queryDatasetToClasscificationById(id);
    }

    @Override
    public List<DatasetToClasscification> queryAllDatasetToClasscification() {
        return DatasetToClasscificationMapper.queryAllDatasetToClasscification();
    }

    @Override
    public DatasetToClasscification queryDatasetToClasscificationByName(String name) {
        return DatasetToClasscificationMapper.queryDatasetToClasscificationByName(name);
    }
}

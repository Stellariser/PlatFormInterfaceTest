package com.kaung.service;

import com.kaung.mapper.DatasetsMapper;
import com.kaung.pogo.Datasets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatasetsServiceImpl implements DatasetsService{

    @Autowired
    private DatasetsMapper datasetsMapper;

    public void setDatasetsMapper(DatasetsMapper datasetsMapper) {
        this.datasetsMapper = datasetsMapper;
    }


    public int addDatasets(Datasets Datasets) {
        return datasetsMapper.addDatasets(Datasets);
    }


    public int deleteDatasetsById(int id) {
        return datasetsMapper.deleteDatasetsById(id);
    }


    public int updateDatasets(Datasets Datasets) {
        return datasetsMapper.updateDatasets(Datasets);
    }


    public Datasets queryDatasetsById(int id) {
        return null;
    }


    public List<Datasets> queryAllDatasets() {
        return datasetsMapper.queryAllDatasets();
    }


    public Datasets queryDatasetsByName(String name) {
        return datasetsMapper.queryDatasetsByName(name);
    }
}

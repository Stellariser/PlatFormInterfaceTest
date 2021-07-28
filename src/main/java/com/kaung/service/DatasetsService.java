package com.kaung.service;

import com.kaung.pogo.Datasets;
import com.kaung.pogo.QueryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DatasetsService {
    int addDatasets(Datasets Datasets);

    int deleteDatasetsById(int id);

    int updateDatasets(Datasets Datasets);

    Datasets queryDatasetsById(int id);

    List<Datasets> queryAllDatasets();

    Datasets queryDatasetsByName(String name);

    List<Datasets> queryDatasetsVague(QueryInfo queryInfo);
}

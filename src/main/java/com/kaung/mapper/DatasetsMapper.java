package com.kaung.mapper;

import com.kaung.pogo.Datasets;

import com.kaung.pogo.QueryInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DatasetsMapper {
    int addDatasets(Datasets Datasets);

    int deleteDatasetsById(int id);

    int updateDatasets(Datasets Datasets);

    Datasets queryDatasetsById(int id);

    List<Datasets> queryAllDatasets();

    Datasets queryDatasetsByName(String name);

    List<Datasets> queryDatasetsVague(QueryInfo queryInfo);
}

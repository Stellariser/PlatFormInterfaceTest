package com.kaung.service;

import com.kaung.pogo.Classcification;
import com.kaung.pogo.DatasetToClasscification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DatasetToClasscificationService {
    int addDatasetToClasscification(DatasetToClasscification DatasetToClasscification);

    int deleteDatasetToClasscificationById(int id);

    int updateDatasetToClasscification(DatasetToClasscification DatasetToClasscification);

    DatasetToClasscification queryDatasetToClasscificationById(int id);

    List<DatasetToClasscification> queryAllDatasetToClasscification();

    DatasetToClasscification queryDatasetToClasscificationByName(String name);
}

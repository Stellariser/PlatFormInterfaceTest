package com.kaung.mapper;

import com.kaung.pogo.Classcification;
import com.kaung.pogo.DatasetToClasscification;
import com.kaung.pogo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DatasetToClasscificationMapper {
    int addDatasetToClasscification(DatasetToClasscification DatasetToClasscification);

    int deleteDatasetToClasscificationById(int id);

    int updateDatasetToClasscification(DatasetToClasscification DatasetToClasscification);

    DatasetToClasscification queryDatasetToClasscificationById(int id);

    List<DatasetToClasscification> queryAllDatasetToClasscification();

    DatasetToClasscification queryDatasetToClasscificationByName(String name);
}

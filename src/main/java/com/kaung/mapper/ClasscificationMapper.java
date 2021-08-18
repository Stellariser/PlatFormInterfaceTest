package com.kaung.mapper;

import com.kaung.pogo.Classcification;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClasscificationMapper {
    int addClasscification(Classcification Classcification);

    int deleteClasscificationById(int id);

    int updateClasscification(Classcification Classcification);

    Classcification queryClasscificationById(int id);

    List<Classcification> queryAllClasscification();

    Classcification queryClasscificationByName(String name);

    List<Classcification> queryClasscificationVague(QueryInfo queryInfo);
}

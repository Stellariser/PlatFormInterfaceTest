package com.kaung.service;

import com.kaung.mapper.ClasscificationMapper;
import com.kaung.mapper.UserMapper;
import com.kaung.pogo.Classcification;
import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClasscificationService {


    int addClasscification(Classcification Classcification);

    int deleteClasscificationById(int id);

    int updateClasscification(Classcification Classcification);

    Classcification queryClasscificationById(int id);

    List<Classcification> queryAllClasscification();

    Classcification queryClasscificationByName(String name);

    List<Classcification> queryClasscificationVague(QueryInfo queryInfo);
}

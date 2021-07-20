package com.kaung.service;

import com.kaung.mapper.ClasscificationMapper;
import com.kaung.mapper.UserMapper;
import com.kaung.pogo.Classcification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClasscificationService {


    int addClasscification(Classcification Classcification);

    int deleteClasscificationById(int id);

    int updateClasscification(Classcification Classcification);

    ClasscificationMapper queryClasscificationById(int id);

    List<Classcification> queryAllClasscification();

    ClasscificationMapper queryClasscificationByName(String name);
}

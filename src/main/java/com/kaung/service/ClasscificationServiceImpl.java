package com.kaung.service;

import com.kaung.mapper.ClasscificationMapper;
import com.kaung.mapper.DatasetsMapper;
import com.kaung.pogo.Classcification;
import com.kaung.pogo.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasscificationServiceImpl implements ClasscificationService{

    @Autowired
    private ClasscificationMapper classcificationMapper;

    public void setClasscificationMapper(ClasscificationMapper classcificationMapper) {
        this.classcificationMapper = classcificationMapper;
    }


    public int addClasscification(Classcification Classcification) {
        return classcificationMapper.addClasscification(Classcification);
    }


    public int deleteClasscificationById(int id) {
        return classcificationMapper.deleteClasscificationById(id);
    }


    public int updateClasscification(Classcification Classcification) {
        return classcificationMapper.updateClasscification(Classcification);
    }


    public ClasscificationMapper queryClasscificationById(int id) {
        return classcificationMapper.queryClasscificationById(id);
    }


    public List<Classcification> queryAllClasscification() {
        return classcificationMapper.queryAllClasscification();
    }


    public ClasscificationMapper queryClasscificationByName(String name) {
        return classcificationMapper.queryClasscificationByName(name);
    }

    @Override
    public List<Classcification> queryClasscificationVague(QueryInfo queryInfo) {
        return classcificationMapper.queryClasscificationVague(queryInfo);
    }
}

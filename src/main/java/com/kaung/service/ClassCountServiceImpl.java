package com.kaung.service;

import com.kaung.mapper.ClassCountMapper;
import com.kaung.pogo.ClassCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassCountServiceImpl implements ClassCountService{
    @Autowired
    private ClassCountMapper classCountMapper;

    public void setClassCountMapper(ClassCountMapper classCountMapper) {
        this.classCountMapper = classCountMapper;
    }

    @Override
    public List<ClassCount> getClassCount() {
        return classCountMapper.getClassCount();
    }
}

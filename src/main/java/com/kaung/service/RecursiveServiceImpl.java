package com.kaung.service;

import com.kaung.mapper.RecursiveMapper;
import com.kaung.pogo.Recursive;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecursiveServiceImpl implements RecursiveService{

    @Autowired
    private RecursiveMapper recursiveMapper;

    public void setRecursiveMapper(RecursiveMapper recursiveMapper) {
        this.recursiveMapper = recursiveMapper;
    }

    @Override
    public int addRecursive(Recursive Recursive) {
        return recursiveMapper.addRecursive(Recursive);
    }

    @Override
    public int deleteRecursiveById(int id) {
        return recursiveMapper.deleteRecursiveById(id);
    }

    @Override
    public int updateRecursive(Recursive Recursive) {
        return recursiveMapper.updateRecursive(Recursive);
    }

    @Override
    public Recursive queryRecursiveById(int id) {
        return recursiveMapper.queryRecursiveById(id);
    }

    @Override
    public List<Recursive> queryAllRecursive() {
        return recursiveMapper.queryAllRecursive();
    }

    @Override
    public Recursive queryRecursiveByName(String name) {
        return recursiveMapper.queryRecursiveByName(name);
    }
}

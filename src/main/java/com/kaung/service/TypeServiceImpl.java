package com.kaung.service;

import com.kaung.mapper.TypeMapper;
import com.kaung.pogo.Type;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeMapper typeMapper;

    public void setTypeMapper(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    @Override
    public int addType(Type Type) {
        return typeMapper.addType(Type);
    }

    @Override
    public int deleteTypeById(int id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public int updateType(Type Type) {
        return typeMapper.updateType(Type);
    }

    @Override
    public Type queryTypeById(int id) {
        return typeMapper.queryTypeById(id);
    }

    @Override
    public List<Type> queryAllType() {
        return typeMapper.queryAllType();
    }

    @Override
    public Type queryTypeByName(String name) {
        return typeMapper.queryTypeByName(name);
    }
}

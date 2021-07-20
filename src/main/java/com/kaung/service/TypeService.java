package com.kaung.service;

import com.kaung.pogo.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    int addType(Type Type);

    int deleteTypeById(int id);

    int updateType(Type Type);

    Type queryTypeById(int id);

    List<Type> queryAllType();

    Type queryTypeByName(String name);
}

package com.kaung.mapper;

import com.kaung.pogo.Type;
import com.kaung.pogo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TypeMapper {
    int addType(Type Type);

    int deleteTypeById(int id);

    int updateType(Type Type);

    Type queryTypeById(int id);

    List<Type> queryAllType();

    Type queryTypeByName(String name);
}

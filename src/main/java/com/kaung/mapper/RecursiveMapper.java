package com.kaung.mapper;

import com.kaung.pogo.Recursive;
import com.kaung.pogo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecursiveMapper {
    int addRecursive(Recursive Recursive);

    int deleteRecursiveById(int id);

    int updateRecursive(Recursive Recursive);

    Recursive queryRecursiveById(int id);

    List<Recursive> queryAllRecursive();

    Recursive queryRecursiveByName(String name);
}

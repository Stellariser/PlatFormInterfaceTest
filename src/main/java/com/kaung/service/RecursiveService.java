package com.kaung.service;

import com.kaung.pogo.Recursive;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecursiveService {
    int addRecursive(Recursive Recursive);

    int deleteRecursiveById(int id);

    int updateRecursive(Recursive Recursive);

    Recursive queryRecursiveById(int id);

    List<Recursive> queryAllRecursive();

    Recursive queryRecursiveByName(String name);
}

package com.kaung.service;

import com.kaung.pogo.ClassCount;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClassCountService {
    List<ClassCount> getClassCount();
}

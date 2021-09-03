package com.kaung.mapper;

import com.kaung.pogo.ClassCount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClassCountMapper {
    List<ClassCount> getClassCount();
}

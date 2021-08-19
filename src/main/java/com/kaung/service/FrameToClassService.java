package com.kaung.service;

import com.kaung.pogo.DatasetToScene;
import com.kaung.pogo.FrameToClass;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FrameToClassService {
    int addFrameToClass(FrameToClass FrameToClass);

    int deleteFrameToClassById(int id);

    int updateFrameToClass(FrameToClass FrameToClass);

    FrameToClass queryFrameToClassById(int id);

    List<FrameToClass> queryAllFrameToClass();

    FrameToClass queryFrameToClassByName(String name);

    int getLastInsert();
}

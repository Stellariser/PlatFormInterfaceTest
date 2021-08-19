package com.kaung.mapper;

import com.kaung.pogo.DatasetToScene;
import com.kaung.pogo.FrameToClass;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface FrameToClassMapper {
    int addFrameToClass(FrameToClass FrameToClass);

    int deleteFrameToClassById(int id);

    int updateFrameToClass(FrameToClass FrameToClass);

    FrameToClass queryFrameToClassById(int id);

    List<FrameToClass> queryAllFrameToClass();

    FrameToClass queryFrameToClassByName(String name);

    int getLastInsert();
}

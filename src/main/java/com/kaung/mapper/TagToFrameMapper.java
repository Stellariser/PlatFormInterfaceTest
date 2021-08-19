package com.kaung.mapper;

import com.kaung.pogo.FrameToScene;
import com.kaung.pogo.TagToFrame;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TagToFrameMapper {
    int addTagToFrame(TagToFrame TagToFrame);

    int deleteTagToFrameById(int id);

    int updateTagToFrame(TagToFrame TagToFrame);

    TagToFrame queryTagToFrameById(int id);

    List<TagToFrame> queryAllTagToFrame();

    TagToFrame queryTagToFrameByName(String name);
    int getLastInsert();
}

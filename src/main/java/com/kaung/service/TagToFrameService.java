package com.kaung.service;

import com.kaung.pogo.FrameToScene;
import com.kaung.pogo.TagToFrame;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagToFrameService {
    int addTagToFrame(TagToFrame TagToFrame);

    int deleteTagToFrameById(int id);

    int updateTagToFrame(TagToFrame TagToFrame);

    TagToFrame queryTagToFrameById(int id);

    List<TagToFrame> queryAllTagToFrame();

    TagToFrame queryTagToFrameByName(String name);

    int getLastInsert();
}

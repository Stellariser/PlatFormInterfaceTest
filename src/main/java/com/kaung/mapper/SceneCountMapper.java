package com.kaung.mapper;

import com.kaung.pogo.SceneCount;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SceneCountMapper {
    List<SceneCount> getSceneCount();
}

package com.kaung.service;

import com.kaung.pogo.SceneCount;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SceneCountService {
    List<SceneCount> getSceneCount();
}

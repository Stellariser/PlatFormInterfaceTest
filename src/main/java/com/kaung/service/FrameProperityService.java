package com.kaung.service;

import com.kaung.pogo.FrameProperity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FrameProperityService {
    int addFrameProperity(FrameProperity FrameProperity);

    int deleteFrameProperityById(int id);

    int updateFrameProperity(FrameProperity FrameProperity);

    FrameProperity queryFrameProperityById(int id);

    List<FrameProperity> queryAllFrameProperity();

    FrameProperity queryFrameProperityByName(String name);
}

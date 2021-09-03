package com.kaung.service;

import com.kaung.pogo.FrameProperity;
import com.kaung.vo.FrameAddForm;
import com.kaung.vo.ProperityQueryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FrameProperityService {
    int addFrameProperity(FrameAddForm FrameAddForm);

    int deleteFrameProperityById(int id);

    int updateFrameProperity(FrameProperity FrameProperity);

    FrameProperity queryFrameProperityById(int id);

    List<FrameProperity> queryAllFrameProperity();

    FrameProperity queryFrameProperityByName(String name);

    List<FrameProperity> queryGlobalFrame(ProperityQueryInfo ProperityQueryInfo);

    int getLastInsert();

    int updateFrameProperityInfo(FrameProperity FrameProperity);

    int getFrameAmount();
}

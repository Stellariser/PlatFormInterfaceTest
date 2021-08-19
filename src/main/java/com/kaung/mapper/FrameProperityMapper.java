package com.kaung.mapper;

import com.kaung.pogo.FrameProperity;
import com.kaung.pogo.User;
import com.kaung.vo.FrameAddForm;
import com.kaung.vo.ProperityQueryInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FrameProperityMapper {
    int addFrameProperity(FrameAddForm FrameAddForm);

    int deleteFrameProperityById(int id);

    int updateFrameProperity(FrameProperity FrameProperity);

    FrameProperity queryFrameProperityById(int id);

    List<FrameProperity> queryAllFrameProperity();

    FrameProperity queryFrameProperityByName(String name);

    List<FrameProperity> queryGlobalFrame(ProperityQueryInfo ProperityQueryInfo);

    int getLastInsert();
}

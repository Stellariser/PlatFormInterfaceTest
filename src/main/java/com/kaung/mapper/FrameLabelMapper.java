package com.kaung.mapper;

import com.kaung.pogo.FrameLabel;
import com.kaung.pogo.LabelQueryInfo;
import com.kaung.pogo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FrameLabelMapper {
    int addFrameLabel(FrameLabel FrameLabel);

    int deleteFrameLabelById(int id);

    int updateFrameLabel(FrameLabel FrameLabel);

    FrameLabel queryFrameLabelById(int id);

    List<FrameLabel> queryAllFrameLabel();

    List<FrameLabel> queryFrameLabelByName(LabelQueryInfo LabelQueryInfo);
}

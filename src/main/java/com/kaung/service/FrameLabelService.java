package com.kaung.service;

import com.kaung.pogo.FrameLabel;
import com.kaung.pogo.LabelQueryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FrameLabelService {
    int addFrameLabel(FrameLabel FrameLabel);

    int deleteFrameLabelById(int id);

    int updateFrameLabel(FrameLabel FrameLabel);

    FrameLabel queryFrameLabelById(int id);

    List<FrameLabel> queryAllFrameLabel();

    List<FrameLabel> queryFrameLabelByName(LabelQueryInfo LabelQueryInfo);
}

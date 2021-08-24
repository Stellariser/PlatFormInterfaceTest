package com.kaung.mapper;

import com.kaung.pogo.Audit;
import com.kaung.pogo.FrameAudit;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface FrameAuditMapper {
    int addFrameAudit(FrameAudit FrameAudit);

    int deleteFrameAuditById(int id);

    int updateFrameAudit(FrameAudit FrameAudit);

    FrameAudit queryFrameAuditById(int id);

    List<FrameAudit> queryAllFrameAudit();

    FrameAudit queryFrameAuditByName(String name);

}

package com.kaung.mapper;

import com.kaung.pogo.Audit;
import com.kaung.pogo.LabelAudit;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LabelAuditMapper {
    int addLabelAudit(LabelAudit LabelAudit);

    int deleteLabelAuditById(int id);

    int updateLabelAudit(LabelAudit LabelAudit);

    LabelAudit queryLabelAuditById(int id);

    List<LabelAudit> queryAllLabelAudit();

    LabelAudit queryLabelAuditByName(String name);
}

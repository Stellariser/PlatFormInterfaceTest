package com.kaung.service;

import com.kaung.pogo.LabelAudit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LabelAuditService {
    int addLabelAudit(LabelAudit LabelAudit);

    int deleteLabelAuditById(int id);

    int updateLabelAudit(LabelAudit LabelAudit);

    LabelAudit queryLabelAuditById(int id);

    List<LabelAudit> queryAllLabelAudit();

    LabelAudit queryLabelAuditByName(String name);
}

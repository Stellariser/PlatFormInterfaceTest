package com.kaung.service;

import com.kaung.pogo.FrameAudit;
import com.kaung.vo.DenyForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FrameAuditService {
    int addFrameAudit(FrameAudit FrameAudit);

    int deleteFrameAuditById(int id);

    int updateFrameAudit(FrameAudit FrameAudit);

    FrameAudit queryFrameAuditById(int id);

    List<FrameAudit> queryAllFrameAudit();

    FrameAudit queryFrameAuditByName(String name);
    int Deny(DenyForm denyForm);
}

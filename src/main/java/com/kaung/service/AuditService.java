package com.kaung.service;

import com.kaung.pogo.Audit;
import com.kaung.pogo.FrameLabel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuditService {
    int addAudit(Audit Audit);

    int deleteAuditById(int id);

    int updateAudit(Audit Audit);

    Audit queryAuditById(int id);

    List<Audit> queryAllAudit();

    Audit queryAuditByName(String name);
}

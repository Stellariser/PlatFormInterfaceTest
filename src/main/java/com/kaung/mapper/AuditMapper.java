package com.kaung.mapper;

import com.kaung.pogo.Audit;

import java.util.List;

public interface AuditMapper {
    int addAudit(Audit Audit);

    int deleteAuditById(int id);

    int updateAudit(Audit Audit);

    Audit queryAuditById(int id);

    List<Audit> queryAllAudit();

    Audit queryAuditByName(String name);
}

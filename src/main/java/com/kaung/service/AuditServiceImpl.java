package com.kaung.service;

import com.kaung.mapper.AuditMapper;
import com.kaung.pogo.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuditServiceImpl implements AuditService{
    @Autowired
    private AuditMapper auditMapper;

    public void setAuditMapper(AuditMapper auditMapper) {
        this.auditMapper = auditMapper;
    }

    @Override
    public int addAudit(Audit Audit) {
        return auditMapper.addAudit(Audit);
    }

    @Override
    public int deleteAuditById(int id) {
        return auditMapper.deleteAuditById(id);
    }

    @Override
    public int updateAudit(Audit Audit) {
        return auditMapper.updateAudit(Audit);
    }

    @Override
    public Audit queryAuditById(int id) {
        return auditMapper.queryAuditById(id);
    }

    @Override
    public List<Audit> queryAllAudit() {
        return auditMapper.queryAllAudit();
    }

    @Override
    public Audit queryAuditByName(String name) {
        return auditMapper.queryAuditByName(name);
    }
}

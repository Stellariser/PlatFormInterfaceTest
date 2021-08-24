package com.kaung.service;

import com.kaung.mapper.FrameProperityMapper;
import com.kaung.mapper.LabelAuditMapper;
import com.kaung.pogo.LabelAudit;
import com.kaung.vo.DenyForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LabelAuditServiceImpl implements LabelAuditService{
    @Autowired
    private LabelAuditMapper labelAuditMapper;

    public void setLabelAuditMapper(LabelAuditMapper labelAuditMapper) {
        this.labelAuditMapper = labelAuditMapper;
    }

    @Override
    public int addLabelAudit(LabelAudit LabelAudit) {
        return labelAuditMapper.addLabelAudit(LabelAudit);
    }

    @Override
    public int deleteLabelAuditById(int id) {
        return labelAuditMapper.deleteLabelAuditById(id);
    }

    @Override
    public int updateLabelAudit(LabelAudit LabelAudit) {
        return labelAuditMapper.updateLabelAudit(LabelAudit);
    }

    @Override
    public LabelAudit queryLabelAuditById(int id) {
        return labelAuditMapper.queryLabelAuditById(id);
    }

    @Override
    public List<LabelAudit> queryAllLabelAudit() {
        return labelAuditMapper.queryAllLabelAudit();
    }

    @Override
    public LabelAudit queryLabelAuditByName(String name) {
        return labelAuditMapper.queryLabelAuditByName(name);
    }

    @Override
    public int Deny(DenyForm denyForm) {
        return labelAuditMapper.Deny(denyForm);
    }
}

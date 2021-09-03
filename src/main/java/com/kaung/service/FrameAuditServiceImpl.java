package com.kaung.service;

import com.kaung.mapper.DatasetToSceneMapper;
import com.kaung.mapper.FrameAuditMapper;
import com.kaung.pogo.FrameAudit;
import com.kaung.vo.DenyForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FrameAuditServiceImpl implements FrameAuditService{
    @Autowired
    private FrameAuditMapper frameAuditMapper;

    public void setFrameAuditMapper(FrameAuditMapper frameAuditMapper) {
        this.frameAuditMapper = frameAuditMapper;
    }

    @Override
    public int addFrameAudit(FrameAudit FrameAudit) {
        return frameAuditMapper.addFrameAudit(FrameAudit);
    }

    @Override
    public int deleteFrameAuditById(int id) {
        return frameAuditMapper.deleteFrameAuditById(id);
    }

    @Override
    public int updateFrameAudit(FrameAudit FrameAudit) {
        return frameAuditMapper.updateFrameAudit(FrameAudit);
    }

    @Override
    public FrameAudit queryFrameAuditById(int id) {
        return frameAuditMapper.queryFrameAuditById(id);
    }

    @Override
    public List<FrameAudit> queryAllFrameAudit() {
        return frameAuditMapper.queryAllFrameAudit();
    }

    @Override
    public FrameAudit queryFrameAuditByName(String name) {
        return frameAuditMapper.queryFrameAuditByName(name);
    }

    @Override
    public int Deny(DenyForm denyForm) {
        return frameAuditMapper.Deny(denyForm);
    }
}

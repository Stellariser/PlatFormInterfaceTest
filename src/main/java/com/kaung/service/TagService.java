package com.kaung.service;

import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.Scene;
import com.kaung.pogo.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
    public interface TagService {
        int addTag(Tag Tag);

        int deleteTagById(int id);

        int updateTag(Tag Tag);

        Tag queryTagById(int id);

        List<Tag> queryAllTag();

        Tag queryTagByName(String name);

        List<Tag> queryTagVague(QueryInfo queryInfo);

        List<Tag> queryTag();
    }


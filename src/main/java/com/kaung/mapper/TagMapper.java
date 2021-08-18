package com.kaung.mapper;

import com.kaung.pogo.QueryInfo;
import com.kaung.pogo.Scene;
import com.kaung.pogo.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TagMapper {
    int addTag(Tag Tag);

    int deleteTagById(int id);

    int updateTag(Tag Tag);

    Tag queryTagById(int id);

    List<Tag> queryAllTag();

    Tag queryTagByName(String name);

    List<Tag> queryTag();

    List<Tag> queryTagVague(QueryInfo queryInfo);
}

package com.nf147.ssm_pet_ajax.dao;

import com.nf147.ssm_pet_ajax.entity.Tag;
import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Tag record);

    Tag selectByPrimaryKey(Integer tId);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);
}
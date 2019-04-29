package com.nf147.ssm_pet_spring.dao;

import com.nf147.ssm_pet_spring.entity.Tag;
import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Tag record);

    Tag selectByPrimaryKey(Integer tId);

    List<Tag> selectAll();

    int updateByPrimaryKey(Tag record);
}
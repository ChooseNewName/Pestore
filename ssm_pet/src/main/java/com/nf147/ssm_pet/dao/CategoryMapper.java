package com.nf147.ssm_pet.dao;

import com.nf147.ssm_pet.entity.Category;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Category record);

    Category selectByPrimaryKey(Integer cId);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}
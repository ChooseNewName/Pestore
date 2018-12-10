package com.nf147.ssm_pet_ajax.dao;

import com.nf147.ssm_pet_ajax.entity.Category;
import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Category record);

    Category selectByPrimaryKey(Integer cId);

    List<Category> selectAll();

    int updateByPrimaryKey(Category record);
}
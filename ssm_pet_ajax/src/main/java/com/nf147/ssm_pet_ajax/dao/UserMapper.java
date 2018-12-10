package com.nf147.ssm_pet_ajax.dao;

import com.nf147.ssm_pet_ajax.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
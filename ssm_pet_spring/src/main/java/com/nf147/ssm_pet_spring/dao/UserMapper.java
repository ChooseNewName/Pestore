package com.nf147.ssm_pet_spring.dao;

import com.nf147.ssm_pet_spring.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
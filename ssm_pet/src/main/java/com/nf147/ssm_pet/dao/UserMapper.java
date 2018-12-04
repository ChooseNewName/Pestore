package com.nf147.ssm_pet.dao;

import com.nf147.ssm_pet.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
package com.nf147.ssm_pet_spring.dao;

import com.nf147.ssm_pet_spring.entity.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer oId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}
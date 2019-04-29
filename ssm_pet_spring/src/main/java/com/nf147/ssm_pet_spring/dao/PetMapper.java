package com.nf147.ssm_pet_spring.dao;

import com.nf147.ssm_pet_spring.entity.Pet;
import java.util.List;

public interface PetMapper {
    int deleteByPrimaryKey(int pId);

    int insert(Pet pet);

    Pet selectByPrimaryKey(Integer pId);

    List<Pet> selectAll();

    int updateByPrimaryKey(Pet record);

    List<Pet> selectVague(String strings);


}
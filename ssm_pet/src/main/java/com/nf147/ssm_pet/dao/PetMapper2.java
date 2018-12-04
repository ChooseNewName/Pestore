package com.nf147.ssm_pet.dao;

import com.nf147.ssm_pet.entity.Pet;

import java.util.List;

public interface PetMapper2 {

    int deleteByPrimaryKey(int pId);

    int insert(Pet pet);

    Pet selectByPrimaryKey(Integer pId);

    List<Pet> selectAll();

    int updateByPrimaryKey(Pet record);

    List<Pet> selectVague(String strings);


}

package com.nf147.ssm_pet_spring.service;

import com.nf147.ssm_pet_spring.entity.Pet;

import java.io.IOException;
import java.util.List;

public interface RedisService {
    List<Pet> findAll() throws IOException;
    int insertPet (Pet pet);
    int getById();
}

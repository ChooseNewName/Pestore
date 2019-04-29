package com.nf147.ssm_pet_spring.service;

import com.nf147.ssm_pet_spring.entity.Pet;

import java.util.List;

public interface NewsService {

     List<Pet> findAll();

     int insertNews ();

     int getById ();
}

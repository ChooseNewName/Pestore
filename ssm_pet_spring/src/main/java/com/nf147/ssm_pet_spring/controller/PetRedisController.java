package com.nf147.ssm_pet_spring.controller;

import com.nf147.ssm_pet_spring.entity.Pet;
import com.nf147.ssm_pet_spring.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

//
//@RestController
//@CrossOrigin
public class PetRedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/list")
    public List<Pet> findAll() throws IOException {
        return redisService.findAll();
    }

    public int insertPet(Pet pet) {
        return redisService.insertPet(pet);
    }

}

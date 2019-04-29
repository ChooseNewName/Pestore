package com.nf147.ssm_pet_spring.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf147.ssm_pet_spring.dao.PetMapper;
import com.nf147.ssm_pet_spring.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.List;

@Service
public class PetRedisService implements RedisService {
    @Autowired
    private PetMapper petMapper;

    @Override
    public List<Pet> findAll() throws IOException {
//      第一步：new 一个 Jedis
        Jedis jedis = new Jedis();
//      第二步：定义一个 key 值
        String key = "listNews";
//
        ObjectMapper objectMapper = new ObjectMapper();

//      判断缓存中有没有我们想要的数据，有则直接返回数据
        if (jedis.exists(key)) {
//          首先通过 ket 值把数据查询出来，然后使用 TypeReference 把数据转换成 List<Pet>
//          readValue 把查询的出来的数据转换成 Json 字符串
            return objectMapper.readValue(jedis.get(key), new TypeReference<List<Pet>>() {});
        }else{
//      没有就从数据库中查询出来把数据放到缓存中，然后返回。。
        List<Pet> petList = petMapper.selectAll();
//      把 petList 集合 序列化成字符串。
        jedis.set(key, objectMapper.writeValueAsString(petList));
        return petList;
        }
    }

    @Override
    public int insertPet(Pet pet) {

        Jedis jedis = new Jedis();
        String petListKey = "petList";

//      我们添加、修改或者删除的时候，先缓存的数据清空
//      因为可以保证下次查询中的数据完整性，如果我们添加了一个数据，不清空缓存中的内容
//      那么，下次查询到旧数据，就是没有添加数据前的数据，所以我们在做添加、修改或者删除的时候，
//      需要先清空缓冲区的内容。
        if (jedis.exists(petListKey))jedis.del(petListKey);

        return petMapper.insert(pet);
    }

    @Override
    public int getById() {
        return 0;
    }
}

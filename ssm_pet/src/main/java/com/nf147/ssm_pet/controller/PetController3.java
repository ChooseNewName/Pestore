package com.nf147.ssm_pet.controller;

import com.nf147.ssm_pet.dao.CategoryMapper;
import com.nf147.ssm_pet.dao.PetMapper;
import com.nf147.ssm_pet.dao.TagMapper;
import com.nf147.ssm_pet.entity.Category;
import com.nf147.ssm_pet.entity.Pet;
import com.nf147.ssm_pet.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PetController3 {

    @Autowired
    private PetMapper petMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;

    //    查询全部宠物
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> queryAllPet() {
        List<Pet> petList = petMapper.selectAll();
        List<Category> categoryList = categoryMapper.selectAll();
        List<Tag> tagList = tagMapper.selectAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("petList", petList);
        map.put("categoryList", categoryList);
        map.put("tagList", tagList);
        System.out.println("Map集合大小：" + map.size());
        System.out.println("categoryList大小：" + categoryList.size());
        System.out.println("tagList大小：" + tagList.size());
        return map;
    }
//


}

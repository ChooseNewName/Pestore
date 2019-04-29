package com.nf147.ssm_pet_spring.controller;

import com.nf147.ssm_pet_spring.dao.CategoryMapper;
import com.nf147.ssm_pet_spring.dao.PetMapper;
import com.nf147.ssm_pet_spring.dao.TagMapper;
import com.nf147.ssm_pet_spring.entity.Category;
import com.nf147.ssm_pet_spring.entity.Pet;
import com.nf147.ssm_pet_spring.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
//@CrossOrigin
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
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("petList", petList());
        map.put("categoryList", categoryList());
        map.put("tagList", tagList());
        return map;
    }

    //添加宠物
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addPet(@RequestBody Pet pet) {
        return petMapper.insert(pet);
    }

    //删除宠物
    @RequestMapping(value = "/del",method = RequestMethod.DELETE)
    public int delPet(int pId){
        System.out.println(pId);
        int num = petMapper.deleteByPrimaryKey(pId);
        System.out.println(num);
        return num;
    }




    public List<Pet> petList(){
        return petMapper.selectAll();
    }
    public List<Category> categoryList (){
        return categoryMapper.selectAll();
    }
    public List<Tag> tagList (){
        return tagMapper.selectAll();
    }
}

package com.nf147.ssm_pet.controller;

import com.google.gson.Gson;
import com.nf147.ssm_pet.dao.CategoryMapper;
import com.nf147.ssm_pet.dao.PetMapper2;
import com.nf147.ssm_pet.dao.TagMapper;
import com.nf147.ssm_pet.entity.Category;
import com.nf147.ssm_pet.entity.Pet;
import com.nf147.ssm_pet.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import java.math.BigDecimal;
import java.util.List;

//@Controller
public class PetController2 {

    @Autowired
    private PetMapper2 petMapper2;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;

    //    查询全部宠物
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String selectAll(Model model) {
        List<Pet> petList = petList();
        model.addAttribute(petList);
        model.addAttribute(categoryList());
        model.addAttribute(tagList());
        return "pet2";
    }

    //    删除宠物
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deletePet(int pId) {
        System.out.println(pId);
        int num = petMapper2.deleteByPrimaryKey(pId);
        if (num != 0) {
            return "{\"msg\":\"删除成功\"}";
        }
        return "{\"msg\":\"删除失败。。\"}";
    }

    //    新增宠物
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String insertPet(String pName, BigDecimal pPrice, int tId,int categoryId, String pStatus) {
        Pet pet = new Pet(categoryId,tId,pName, pPrice,pStatus);
        System.out.println(pet);
        int num = petMapper2.insert(pet);
        if (num != 0) {
            return "{\"msg\":\"新增成功\"}";
        }
        return "{\"msg\":\"新增失败。。\"}";
    }

//    搜索
    @GetMapping("/Vague")
    @ResponseBody
    public List<Pet> searchPet(Model model,String strings){
        List<Pet> petList= petMapper2.selectVague(strings);
        model.addAttribute(petList());
        model.addAttribute(tagList());
        model.addAttribute(categoryList());

        return petList;
    }


    public List<Pet> petList() {
        return petMapper2.selectAll();
    }

    public List<Category> categoryList() {
        return categoryMapper.selectAll();
    }

    public List<Tag> tagList() {
        return tagMapper.selectAll();
    }
}

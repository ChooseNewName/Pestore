package com.nf147.ssm_pet.controller;

import com.nf147.ssm_pet.dao.CategoryMapper;
import com.nf147.ssm_pet.dao.PetMapper;

import com.nf147.ssm_pet.dao.TagMapper;
import com.nf147.ssm_pet.entity.Category;
import com.nf147.ssm_pet.entity.Pet;
import com.nf147.ssm_pet.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@CrossOrigin
public class PetController {

    @Autowired
    private PetMapper petMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;

    //    查询全部宠物
    @GetMapping(value = "/list")
    public String queryPetAll(Model model) {
        model.addAttribute("petList", petList());
        model.addAttribute("categoryList", categoryList());
        model.addAttribute("tagList", tagList());
        return "pet";
    }

    //    新增一个宠物
    @PostMapping(value = "/add")
    public String insertPet(Pet pet) {
        petMapper.insert(pet);
        return "redirect:/list";
    }

    //    删除一个宠物
    @RequestMapping("/del/{pId}")
    public String del(@PathVariable("pId") int pId) {
        petMapper.deleteByPrimaryKey(pId);
        return "redirect:/list";
    }

    //   根据ID查询一个宠物
    @GetMapping("/select/{pId}")
    public String select(@PathVariable("pId") int pId, Model model) {
        Pet pet = petMapper.selectByPrimaryKey(pId);
        model.addAttribute("pet", pet);
        System.out.println(pet);
        model.addAttribute("petList", petList());
        model.addAttribute("categoryList", categoryList());
        model.addAttribute("tagList", tagList());
        return "updatePet";
    }

    //    修改宠物信息
    @PostMapping("/update")
    public String update(Pet pet) {
        System.out.println(pet);
        petMapper.updateByPrimaryKey(pet);
        return "redirect:/list";
    }

    //    模糊查询
    @PostMapping("/Vague")
    public String query(Model model, String strings) {
        System.out.println(strings);
        List<Pet> petList = petMapper.selectVague("%" + strings + "%");
        model.addAttribute("petList", petList);
        model.addAttribute("categoryList", categoryList());
        model.addAttribute("tagList", tagList());
        return "pet";
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

package com.sheryians.major.service;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    //adding categories method
    public void addCategory(Category category){categoryRepository.save(category);}
    //Reterieving categories
    public List<Category> getAllCategory(){return categoryRepository.findAll();}
    //removing a categories by id
    public void removeCategoryById(int id){categoryRepository.deleteById(id);}
    //finding category by id for update purspose
    public Optional<Category> getCategoryById(int id){return categoryRepository.findById(id);}


}

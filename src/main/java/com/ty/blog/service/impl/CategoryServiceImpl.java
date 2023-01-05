package com.ty.blog.service.impl;

import com.ty.blog.domain.entity.Category;
import com.ty.blog.domain.request.CategoryDataRequest;
import com.ty.blog.helper.CategoryHelper;
import com.ty.blog.repository.CategoryRepository;
import com.ty.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void saveCategoryData(CategoryDataRequest request) {
        Category category = CategoryHelper.categoryEntityConverter(request);
        categoryRepository.save(category);
    }
}

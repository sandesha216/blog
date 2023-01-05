package com.ty.blog.contraller;

import com.ty.blog.domain.request.CategoryDataRequest;
import com.ty.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public void saveCategory(@RequestBody CategoryDataRequest request) {
        categoryService.saveCategoryData(request);
    }
}

package com.spc.goods.product.service.impl;

import com.spc.goods.product.dataobject.ProductCategory;
import com.spc.goods.product.repository.ProductCategoryRepository;
import com.spc.goods.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> productCategories=productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
        return productCategories;
    }
}

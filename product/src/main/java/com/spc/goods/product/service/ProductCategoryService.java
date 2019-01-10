package com.spc.goods.product.service;

import com.spc.goods.product.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

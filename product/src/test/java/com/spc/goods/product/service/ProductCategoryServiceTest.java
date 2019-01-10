package com.spc.goods.product.service;

import com.spc.goods.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceTest {
    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> productCategories=productCategoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(productCategories.size()>0);
    }

}
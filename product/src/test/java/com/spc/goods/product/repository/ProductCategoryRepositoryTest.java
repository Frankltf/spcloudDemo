package com.spc.goods.product.repository;

import com.spc.goods.product.dataobject.ProductCategory;
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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findByCategoryTypeIn(){
        List<ProductCategory> productCategories=productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,12));
        System.out.println(productCategories);
    }

}
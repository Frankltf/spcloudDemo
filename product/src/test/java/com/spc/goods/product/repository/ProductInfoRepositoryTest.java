package com.spc.goods.product.repository;

import com.spc.goods.product.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Test
    public void findByProductStatus(){
        List<ProductInfo> productInfos=productInfoRepository.findByProductStatus(0);
        System.out.println(productInfos);
    }
}
package com.spc.goods.product.service.impl;

import com.spc.goods.product.dataobject.ProductInfo;
import com.spc.goods.product.enums.ProductStatus;
import com.spc.goods.product.repository.ProductInfoRepository;
import com.spc.goods.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> productInfo=productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
        return productInfo;
    }
}

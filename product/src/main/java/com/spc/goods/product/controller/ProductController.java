package com.spc.goods.product.controller;

import com.spc.goods.product.VO.ProductInfoVO;
import com.spc.goods.product.VO.ProductVO;
import com.spc.goods.product.VO.ResultVO;
import com.spc.goods.product.dataobject.ProductCategory;
import com.spc.goods.product.dataobject.ProductInfo;
import com.spc.goods.product.service.ProductCategoryService;
import com.spc.goods.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        List<ProductInfo> productInfoList=productService.findUpAll();
        List<Integer> categoryList=productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList=productCategoryService.findByCategoryTypeIn(categoryList);

        List<ProductVO> productVOS=new ArrayList<>();

        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOS(productInfoVOList);
            productVOS.add(productVO);
        }

        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(productVOS);
        return  resultVO;
    }
}

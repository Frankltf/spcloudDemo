package com.spc.goods.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer CategoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOS;
}

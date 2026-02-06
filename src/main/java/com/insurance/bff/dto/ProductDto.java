package com.insurance.bff.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private String productType;
    private Integer coverageAmount;
    private Integer monthlyPremium;
    private Integer policyTermYears;
}

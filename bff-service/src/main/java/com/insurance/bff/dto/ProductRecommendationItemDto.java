package com.insurance.bff.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProductRecommendationItemDto {
    private Long productId;
    private String productName;
    private String productType;
    private Integer coverageAmount;
    private Integer durationYears;
    private Integer monthlyPremium;
    private String familyType;
    private boolean isRecommended;
    private boolean isTopUp;
    private List<String> reasons;
}

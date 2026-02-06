package com.insurance.bff.dto;

import lombok.Data;
import java.util.List;

@Data
public class RecommendationResponseDto {
    private List<ProductRecommendationItemDto> products;
    private String ruleVersion;
    private String status;
}

package com.insurance.bff.client;

import com.insurance.bff.dto.RecommendationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "recommendation-service")
public interface RecommendationClient {

    @GetMapping("/api/recommendations/recommend/{id}")
    RecommendationResponseDto getRecommendations(@PathVariable("id") Long id);
}

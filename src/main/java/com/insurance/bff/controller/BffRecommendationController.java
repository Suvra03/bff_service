package com.insurance.bff.controller;

import com.insurance.bff.client.RecommendationClient;
import com.insurance.bff.dto.RecommendationResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/bff/recommendations")
@RequiredArgsConstructor
public class BffRecommendationController {

    private final RecommendationClient recommendationClient;

    @GetMapping("/{id}")
    public ResponseEntity<RecommendationResponseDto> getRecommendations(
            @PathVariable Long id,
            HttpServletRequest request) {
        Long tokenCustomerId = (Long) request.getAttribute("customerId");
        String role = (String) request.getAttribute("role");

        if (!id.equals(tokenCustomerId) && !"ADMIN".equalsIgnoreCase(role)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        return ResponseEntity.ok(recommendationClient.getRecommendations(id));
    }
}

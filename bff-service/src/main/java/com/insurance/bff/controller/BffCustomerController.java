package com.insurance.bff.controller;

import com.insurance.bff.client.CustomerClient;
import com.insurance.bff.dto.CustomerProfileResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/bff/customers")
@RequiredArgsConstructor
public class BffCustomerController {

    private final CustomerClient customerClient;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfileResponseDto> getCustomerProfile(
            @PathVariable Long id,
            HttpServletRequest request) {
        Long tokenCustomerId = (Long) request.getAttribute("customerId");
        String role = (String) request.getAttribute("role");

        if (!id.equals(tokenCustomerId) && !"ADMIN".equalsIgnoreCase(role)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        return ResponseEntity.ok(customerClient.getProfile(id));
    }
}

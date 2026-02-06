package com.insurance.bff.client;

import com.insurance.bff.dto.CustomerProfileResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/api/customers/{id}/profile")
    CustomerProfileResponseDto getProfile(@PathVariable("id") Long id);
}

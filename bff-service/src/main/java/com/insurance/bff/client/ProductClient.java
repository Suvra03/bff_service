package com.insurance.bff.client;

import com.insurance.bff.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/products")
    List<ProductDto> getProducts(@RequestParam(value = "type", required = false) String type);

    @GetMapping("/api/products/{productCode}")
    ProductDto getProduct(@PathVariable("productCode") String productCode);
}

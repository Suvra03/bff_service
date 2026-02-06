package com.insurance.bff.controller;

import com.insurance.bff.client.ProductClient;
import com.insurance.bff.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/products")
@RequiredArgsConstructor
public class BffProductController {

    private final ProductClient productClient;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(required = false) String type) {
        return ResponseEntity.ok(productClient.getProducts(type));
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String productCode) {
        return ResponseEntity.ok(productClient.getProduct(productCode));
    }
}

package com.insurance.bff.controller;

import com.insurance.bff.client.AuthClient;
import com.insurance.bff.dto.LoginRequestDto;
import com.insurance.bff.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bff/auth")
@RequiredArgsConstructor
public class BffAuthController {

    private final AuthClient authClient;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authClient.login(request));
    }
}

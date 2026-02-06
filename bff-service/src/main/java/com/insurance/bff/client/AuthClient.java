package com.insurance.bff.client;

import com.insurance.bff.dto.LoginRequestDto;
import com.insurance.bff.dto.LoginResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service")
public interface AuthClient {

    @PostMapping("/api/auth/login")
    LoginResponseDto login(@RequestBody LoginRequestDto request);
}

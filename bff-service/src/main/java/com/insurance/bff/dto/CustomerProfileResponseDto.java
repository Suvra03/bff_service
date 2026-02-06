package com.insurance.bff.dto;

import lombok.Data;

@Data
public class CustomerProfileResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String gender;
    private String occupation;
}

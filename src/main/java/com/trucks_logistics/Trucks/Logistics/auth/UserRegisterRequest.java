package com.trucks_logistics.Trucks.Logistics.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(
                @Email @NotBlank String email,
                @NotBlank @Size(min = 3, max = 25) String username,
                @NotBlank @Size(min = 8) String password) {
}

package com.trucks_logistics.Trucks.Logistics.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserLoginResponse(
                @JsonProperty("access_token") String accessToken,
                @JsonProperty("token_type") String tokenType,
                @JsonProperty("expires_in") long expiresIn) {
}

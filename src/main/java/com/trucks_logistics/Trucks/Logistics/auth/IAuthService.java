package com.trucks_logistics.Trucks.Logistics.auth;

public interface IAuthService {
    UserRegisterResponse createUser(UserRegisterRequest request);

    UserLoginResponse loginUser(UserLoginRequest request);
}

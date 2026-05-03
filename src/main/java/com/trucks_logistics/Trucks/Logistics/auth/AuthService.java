package com.trucks_logistics.Trucks.Logistics.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trucks_logistics.Trucks.Logistics.exceptions.EmailDuplicated;

@Service
public class AuthService implements IAuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthRepository authRepository;

    public AuthService(PasswordEncoder passwordEncoder, AuthRepository authRepository) {
        this.passwordEncoder = passwordEncoder;
        this.authRepository = authRepository;
    }

    @Override
    public UserRegisterResponse createUser(UserRegisterRequest request) {
        if (authRepository.findByEmail(request.email()).isPresent()) {
            throw new EmailDuplicated("El email ya está registrado");
        }

        User user = new User();

        // revisar si es asi
        user.setEmail(request.email());
        // encriptar
        String hashedPassword = passwordEncoder.encode(request.password());
        user.setPassword(hashedPassword);
        user.setUsername(request.username());
        authRepository.save(user);
        return UserMapper.toDTO(user);
    }
}

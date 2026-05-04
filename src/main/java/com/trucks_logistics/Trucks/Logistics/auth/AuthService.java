package com.trucks_logistics.Trucks.Logistics.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trucks_logistics.Trucks.Logistics.email.EmailService;
import com.trucks_logistics.Trucks.Logistics.exceptions.EmailDuplicated;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    private final PasswordEncoder passwordEncoder;
    private final AuthRepository authRepository;
    private final JwtService jwtService;
    private final EmailService emailService;

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
        emailService.enviarCodigoVerificacion(user.getEmail(), 12345);
        authRepository.save(user);
        return UserMapper.toDTO(user);
    }

    @Override
    public UserLoginResponse loginUser(UserLoginRequest request) {
        User user = authRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadCredentialsException("Credenciales invalidas"));

        if (user.getUserStatus() == UserStatus.PENDIENTE) {
            throw new DisabledException("Debes verificar tu email antes de iniciar sesion");
        }

        if (user.getUserStatus() == UserStatus.DESACTIVADO) {
            throw new DisabledException("Tu cuenta ha sido desactivada, contacta al soporte");
        }

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadCredentialsException("Credenciales invalidas");
        }

        String accessToken = jwtService.generateToken(user);
        return new UserLoginResponse(accessToken, "Bearer", expirationMs / 1000);
    }
}

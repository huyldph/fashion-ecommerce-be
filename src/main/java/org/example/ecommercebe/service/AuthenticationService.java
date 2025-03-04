package org.example.ecommercebe.service;

import lombok.RequiredArgsConstructor;
import org.example.ecommercebe.dto.auth.AuthenticationRequest;
import org.example.ecommercebe.dto.auth.AuthenticationResponse;
import org.example.ecommercebe.dto.auth.RegisterRequest;
import org.example.ecommercebe.model.Customer;
import org.example.ecommercebe.model.Role;
import org.example.ecommercebe.model.User;
import org.example.ecommercebe.repository.CustomerRepository;
import org.example.ecommercebe.repository.RoleRepository;
import org.example.ecommercebe.repository.UserRepository;
import org.example.ecommercebe.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        Role customerRole = roleRepository.findByName("ROLE_CUSTOMER")
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName("ROLE_CUSTOMER");
                    newRole.setDescription("Customer role");
                    return roleRepository.save(newRole);
                });

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(customerRole)
                .build();
        user = userRepository.save(user);

        var customer = Customer.builder()
                .user(user)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .build();
        customerRepository.save(customer);

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
}
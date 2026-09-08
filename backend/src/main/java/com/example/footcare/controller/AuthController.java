package com.example.footcare.controller;

import com.example.footcare.model.User;
import com.example.footcare.repository.UserRepository;
import com.example.footcare.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User u) {
        if (userRepository.findByEmail(u.getEmail()).isPresent()) return ResponseEntity.badRequest().body(Map.of("error","Email exists"));
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        u.setRole("ROLE_ADMIN");
        userRepository.save(u);
        return ResponseEntity.ok(Map.of("msg","registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        String email = body.get("email");
        String pass = body.get("password");
        return userRepository.findByEmail(email).map(user -> {
            if (passwordEncoder.matches(pass, user.getPassword())) {
                String token = jwtUtil.generateToken(user.getEmail());
                return ResponseEntity.ok(Map.of("token", token));
            }
            return ResponseEntity.status(401).body(Map.of("error","Invalid credentials"));
        }).orElse(ResponseEntity.status(401).body(Map.of("error","Invalid credentials")));
    }
}

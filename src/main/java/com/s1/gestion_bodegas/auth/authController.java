package com.s1.gestion_bodegas.auth;

import com.s1.gestion_bodegas.config.JwtService;
import com.s1.gestion_bodegas.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class authController {
    private final JwtService jwtService;


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        // Validación
        if (username.equals("alejo") && password.equals("2707")) {
            return jwtService.generateToken(username);
        }

        throw new BusinessRuleException("Credenciales inválidas");
    }
}

package myapp.twitter.secuirty.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.service.JwtAuthService;
import myapp.twitter.secuirty.web.dto.auth.JwtRequest;
import myapp.twitter.secuirty.web.dto.auth.JwtResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthTokenController {

    private final JwtAuthService jwtAuthService;

    @PostMapping("/token")
    public JwtResponse getToken(@Valid @RequestBody JwtRequest jwtRequest) {
        return jwtAuthService.authenticate(jwtRequest);
    }
}

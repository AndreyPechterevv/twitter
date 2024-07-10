package myapp.twitter.secuirty.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.service.JwtAuthService;
import myapp.twitter.secuirty.service.JwtTokenService;
import myapp.twitter.secuirty.web.dto.auth.JwtRequest;
import myapp.twitter.secuirty.web.dto.auth.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtAuthServiceImpl implements JwtAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    @Override
    public JwtResponse authenticate(JwtRequest request) {
        Authentication token = new UsernamePasswordAuthenticationToken(
                request.username,
                request.password
        );
        Authentication authentication = authenticationManager.authenticate(token);
        String idToken = jwtTokenService.generateToken(authentication);
        return new JwtResponse(idToken);
    }
}

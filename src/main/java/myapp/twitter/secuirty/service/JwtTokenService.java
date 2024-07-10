package myapp.twitter.secuirty.service;

import org.springframework.security.core.Authentication;

public interface JwtTokenService {

    String generateToken(Authentication authentication);
}

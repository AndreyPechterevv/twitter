package myapp.twitter.secuirty.service;

import myapp.twitter.secuirty.web.dto.auth.JwtRequest;
import myapp.twitter.secuirty.web.dto.auth.JwtResponse;

public interface JwtAuthService {

    JwtResponse authenticate(JwtRequest request);
}

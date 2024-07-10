package myapp.twitter.secuirty.service.impl;

import lombok.RequiredArgsConstructor;
import myapp.twitter.secuirty.service.JwtTokenService;
import myapp.twitter.secuirty.web.exception.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {

    private final JwtEncoder jwtEncoder;

    @Override
    public String generateToken(Authentication authentication) {
        UserDetails userDetails = Optional.of(authentication.getPrincipal())
                .filter(UserDetails.class::isInstance)
                .map(UserDetails.class::cast)
                .orElseThrow(() -> new AccessDeniedException("не удалось сформировать токен"));

        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        Instant issuesAt = Instant.now();
        Instant expiredAt = issuesAt.plus(1, ChronoUnit.DAYS);
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .claim("scope", roles)
                .subject(userDetails.getUsername())
                .issuedAt(issuesAt)
                .expiresAt(expiredAt)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}

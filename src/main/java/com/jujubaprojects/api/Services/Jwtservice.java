package com.jujubaprojects.api.Services;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class Jwtservice {
    
   private final Jwtservice encoder;

   
  public Jwtservice(Jwtservice encoder) {
    this.encoder = encoder;
}

public String generateToken(AuthenticatedPrincipal authentication) {
    Instant now = Instant.now();
    long expiry = 3600L;

    String scopes = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" ")); // Adiciona espaço entre os escopos

    var claims = JwtClaimsSet.builder()
            .issuer("api")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(authentication.getName())
            .claim("scope", scopes)
            .build();

    return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
}


}

package com.aluracursos.forohub.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aluracursos.forohub.model.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String apiSecret;

  public String generaToken(Usuario usuario) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(apiSecret);
      return JWT.create()
          .withIssuer("foro hub")
          .withSubject(usuario.getUsername())
          .withClaim("id", usuario.getId())
          .withExpiresAt(generaTiempoExpiracion())
          .sign(algorithm);
    } catch (JWTCreationException exception){
        throw new UnsupportedOperationException("Invalid Signing configuration / Couldn't convert Claims.");
    }
  }

  private Instant generaTiempoExpiracion() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
  }

  public String getSubject(String token) {
    if (token == null) {
      throw new IllegalArgumentException("Invalid subject token");
    }
    DecodedJWT decodedJWT;
    try {
        Algorithm algorithm = Algorithm.HMAC256(apiSecret); // Validando la firma del token
        decodedJWT = JWT.require(algorithm)
            .withIssuer("foro hub")
            .build()
            .verify(token);
            
    } catch (JWTVerificationException exception){
      System.out.println(exception.toString());
      throw new RuntimeException("Invalid signature/claims");
    }
    if (decodedJWT.getSubject() == null) {
      throw new RuntimeException("Token inválio");
    }
    return decodedJWT.getSubject();
  }
}

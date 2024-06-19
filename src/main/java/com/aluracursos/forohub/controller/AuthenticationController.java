package com.aluracursos.forohub.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

import com.aluracursos.forohub.infra.security.TokenService;
import com.aluracursos.forohub.dto.usuario.AuthenticationDto;
import com.aluracursos.forohub.dto.usuario.JWTtokenDto;
import com.aluracursos.forohub.model.usuario.Usuario;

@RestController
@RequestMapping(value = "/login")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<JWTtokenDto> login(@RequestBody @Valid AuthenticationDto loginDto) {
    Authentication authToken = new UsernamePasswordAuthenticationToken(loginDto.username(),
                                                                        loginDto.passwd());
    var userAutenticado = authenticationManager.authenticate(authToken);

    var JWTtoken = tokenService.generaToken((Usuario) userAutenticado.getPrincipal());
    // return ResponseEntity.ok(JWTtoken);
    return ResponseEntity.ok(new JWTtokenDto(JWTtoken));
  }
}


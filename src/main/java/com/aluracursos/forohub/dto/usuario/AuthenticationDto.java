package com.aluracursos.forohub.dto.usuario;

public record AuthenticationDto(
  String username,
  String email,
  String passwd
) {}

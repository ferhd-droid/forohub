package com.aluracursos.forohub.dto.topico;

import jakarta.validation.constraints.NotNull;

public record ActualizaTopicoDto(
  // @NotNull Long id,
  Long id,
  String titulo,
  String mensaje,
  String nombreCurso,
  String status,
  Long idUsuario
) {}

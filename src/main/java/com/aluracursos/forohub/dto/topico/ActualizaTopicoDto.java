package com.aluracursos.forohub.dto.topico;

public record ActualizaTopicoDto(
  // @NotNull Long id,
  Long id,
  String titulo,
  String mensaje,
  String nombreCurso,
  String status,
  Long idUsuario
) {}

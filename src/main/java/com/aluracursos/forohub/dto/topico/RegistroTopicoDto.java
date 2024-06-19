package com.aluracursos.forohub.dto.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroTopicoDto(
  @NotNull(message = "{idusuario.obligatorio}")
  Long idUsuario,

  @NotBlank(message = "{titulo.obligatorio}")
  String titulo,

  @NotBlank(message = "{mensaje.obligatorio}")
  String mensaje,

  @NotBlank(message = "{nombreCurso.obligatorio}")
  String nombreCurso
) {}

package com.aluracursos.forohub.dto.topico;

import java.time.LocalDateTime;

import com.aluracursos.forohub.model.topico.Topico;

public record ListadoTopicoDto(
  Long id,
  String titulo,
  String mensaje,
  LocalDateTime fechaCreacion
) {
  public ListadoTopicoDto(Topico topico) {
    this(
          topico.getId(),
          topico.getTitulo(),
          topico.getMensaje(),
          topico.getFechaCreacion()
        );
  }
}

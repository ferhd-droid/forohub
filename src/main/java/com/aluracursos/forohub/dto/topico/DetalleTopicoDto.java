package com.aluracursos.forohub.dto.topico;

import java.time.LocalDateTime;

import com.aluracursos.forohub.model.topico.Topico;

public record DetalleTopicoDto(
  Long id,
  Long idUsuario,
  String titulo,
  String mensaje,
  String nombreCurso,
  String status,
  LocalDateTime fechaCreacion
) {
  public DetalleTopicoDto(Topico topico) {
      this(
        topico.getId(),
        topico.getIdUsuario(),
        topico.getTitulo(),
        topico.getMensaje(),
        topico.getNombreCurso(),
        topico.getStatus(),
        topico.getFechaCreacion()
      );
    }
}

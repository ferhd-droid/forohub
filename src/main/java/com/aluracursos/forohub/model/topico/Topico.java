package com.aluracursos.forohub.model.topico;

import java.time.LocalDateTime;

import com.aluracursos.forohub.dto.topico.RegistroTopicoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;
  private String mensaje;
  private String status;
  private String nombreCurso;
  private Long idUsuario;
  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "idusuario")
  // private Usuario usuario;

  private LocalDateTime fechaCreacion;

  public Topico(RegistroTopicoDto registroTopicoDto) {
    this.idUsuario = registroTopicoDto.idUsuario();
    this.titulo = registroTopicoDto.titulo();
    this.mensaje = registroTopicoDto.mensaje();
    this.status = "OK";
    this.nombreCurso = registroTopicoDto.nombreCurso();
    fechaCreacion =  LocalDateTime.now();
  }
}

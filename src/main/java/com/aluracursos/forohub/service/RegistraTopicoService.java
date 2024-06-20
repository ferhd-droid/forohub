package com.aluracursos.forohub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluracursos.forohub.dto.topico.RegistroTopicoDto;
import com.aluracursos.forohub.dto.topico.RespuestaTopicoDto;
import com.aluracursos.forohub.infra.exception.ValidacionDeIntegridad;
import com.aluracursos.forohub.model.topico.Topico;
import com.aluracursos.forohub.repository.TopicoRepository;
import com.aluracursos.forohub.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class RegistraTopicoService {
  @Autowired
  private UsuarioRepository usuarioRepository;
  @Autowired
  private TopicoRepository topicoRepository;

  public RespuestaTopicoDto registraTopico(@Valid RegistroTopicoDto registroTopicoDto) {
    if (!usuarioRepository.findById(registroTopicoDto.idUsuario()).isPresent()) {
      throw new ValidacionDeIntegridad("Este id del usuario no fué encontrado");
    }

    Topico topico = topicoRepository.save(new Topico(registroTopicoDto));
    RespuestaTopicoDto respuestaTopicoDto = new RespuestaTopicoDto(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion()
    );
    
    return respuestaTopicoDto;
  }
}

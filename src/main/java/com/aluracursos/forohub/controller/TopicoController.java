package com.aluracursos.forohub.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.aluracursos.forohub.dto.topico.RespuestaTopicoDto;
import com.aluracursos.forohub.model.topico.Topico;
import com.aluracursos.forohub.repository.TopicoRepository;
import com.aluracursos.forohub.dto.topico.ListadoTopicoDto;
import com.aluracursos.forohub.dto.topico.RegistroTopicoDto;
import com.aluracursos.forohub.service.RegistraTopicoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
  @Autowired
  private RegistraTopicoService service;
  @Autowired
  private TopicoRepository repository;

  @PostMapping
  @Transactional
  public ResponseEntity<RespuestaTopicoDto> registraTopico(@RequestBody @Valid RegistroTopicoDto registroTopicoDto, UriComponentsBuilder uriComponentsBuilder) {
    System.out.println(registroTopicoDto);
    var response = service.registraTopico(registroTopicoDto);
    // return ResponseEntity.ok(response);
    URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(response.id()).toUri();
    return ResponseEntity.created(url).body(response);
  }

  @GetMapping
  public ResponseEntity <Page<ListadoTopicoDto>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion) {
    return ResponseEntity.ok(repository.findAll(paginacion).map(ListadoTopicoDto::new));
  }

  @SuppressWarnings("rawtypes")
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity eliminaTopico(@PathVariable Long id) {
    Topico topico = repository.getReferenceById(id);
    repository.delete(topico); // DELETE en BD
    // topico.desactivaMedico(); // DELETE lógico
    return ResponseEntity.noContent().build(); // 204 No content
  }
}

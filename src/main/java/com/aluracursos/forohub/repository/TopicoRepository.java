package com.aluracursos.forohub.repository;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aluracursos.forohub.model.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
  // Page<Topico> findAll(Pageable paginacion);
}

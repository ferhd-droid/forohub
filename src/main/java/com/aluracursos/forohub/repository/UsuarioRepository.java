package com.aluracursos.forohub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.aluracursos.forohub.model.usuario.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  UserDetails findByUsername(String username);

}

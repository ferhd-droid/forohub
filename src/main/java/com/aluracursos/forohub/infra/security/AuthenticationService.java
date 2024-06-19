package com.aluracursos.forohub.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aluracursos.forohub.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService {
  @Autowired
  private UsuarioRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    return repository.findByUsername(username);
  }
}
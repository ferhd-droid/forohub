package com.aluracursos.forohub.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.aluracursos.forohub.repository.UsuarioRepository;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @SuppressWarnings({ "null" })
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    // throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
    System.out.println("El filtro está siendo llamado");
    // Obtener el token del encabezado (header)
    var authHeader = request.getHeader("Authorization"); //.replace("Bearer ", "");
    if (authHeader != null) {
      var token = authHeader.replace("Bearer ", "");
      System.out.println(token);
      System.out.println(tokenService.getSubject(token)); // ¿Este usuario tiene sesión?
      var username = tokenService.getSubject(token);
      if (username != null) {
        // Token válido
        var usuario = usuarioRepository.findByUsername(username);
        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());  // Forzamos un inicio de sesión
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    filterChain.doFilter(request, response);
    
    // if (token == "" || token == null) {
    //   throw new RuntimeException("El token enviado no es válido");
    // }
    
  }

}
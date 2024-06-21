package com.aluracursos.forohub.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ManejoDeExcepciones {

  @SuppressWarnings("rawtypes")
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity trataError404() {
    return ResponseEntity.notFound().build();
  }
  
  @SuppressWarnings("rawtypes")
  @ExceptionHandler(ValidacionDeIntegridad.class)
  public ResponseEntity trataError400(ValidacionDeIntegridad e) {
    // return ResponseEntity.badRequest().body("Este id del usuario no existe");
    return ResponseEntity.badRequest().body(e.getMessage());
  }

  @SuppressWarnings("rawtypes")
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity trataError400(MethodArgumentNotValidException e) {
    // var error = e.getFieldError(); solo se obtiene un error
    var errores = e.getFieldErrors().stream().map(ErrorValidacionDto::new).toList();
    return ResponseEntity.badRequest().body(errores);
  }

  public record ErrorValidacionDto(String campo, String error) {
    public ErrorValidacionDto(FieldError error) {
      this(error.getField(), error.getDefaultMessage());
    }
  }
}

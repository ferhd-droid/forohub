package com.aluracursos.forohub.infra.exception;

public class ValidacionDeIntegridad extends RuntimeException {
  public ValidacionDeIntegridad(String msg) {
    super(msg);
  }
}

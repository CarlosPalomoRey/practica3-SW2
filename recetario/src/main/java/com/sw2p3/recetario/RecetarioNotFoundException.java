package com.sw2p3.recetario;

class RecetarioNotFoundException extends RuntimeException {

	RecetarioNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}
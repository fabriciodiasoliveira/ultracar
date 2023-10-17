package com.fabricio.ultracar.infra.exceptions;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity ErrorNotFound(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity ErrorValidation(MethodArgumentNotValidException ex){
        List<FieldError> erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(InnerTratadorDeErros::new).toList());
    }

    private record InnerTratadorDeErros(String campo, String mensagem) {
        public InnerTratadorDeErros (FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}

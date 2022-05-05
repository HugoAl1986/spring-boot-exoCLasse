package com.example.exoClasse.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exoClasse.exceptions.EmailNotFoundException;
import com.example.exoClasse.exceptions.GetStudentsException;
import com.example.exoClasse.exceptions.StudentException;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = { StudentException.class })
  public ResponseEntity<Object> handleUpdate(StudentException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problème rencontré");
  }
  
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = { GetStudentsException.class })
  public ResponseEntity<Object> handleGetStudents(GetStudentsException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Un problème est survenu avec le serveur !");
  }
  
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = { EmailNotFoundException.class })
  public ResponseEntity<Object> handleGetStudentByMail(EmailNotFoundException e) {
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'utilisateur n'a pas été trouvé !");
  }
}
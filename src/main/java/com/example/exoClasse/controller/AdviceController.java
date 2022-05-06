package com.example.exoClasse.controller;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exoClasse.exceptions.EmailNotFoundException;
import com.example.exoClasse.exceptions.ErrorCreateStudentException;
import com.example.exoClasse.exceptions.GetStudentsException;
import com.example.exoClasse.exceptions.StudentException;



@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

  /* ResponseStatus est le code de l'erreur que l'on veut envoyer */
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
  
  /*
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(EmailNotFoundException.class)
  public ResponseEntity<String> handleValidationExceptions(
		  EmailNotFoundException ex) {
		    return ResponseEntity.badRequest().body("Cet utilisateur n'existe pas !!");
		}
  */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(EmailNotFoundException.class)
  public ResponseEntity<ErrorDTO> generateNotFoundException(EmailNotFoundException ex) {
      ErrorDTO errorDTO = new ErrorDTO();
      errorDTO.setMessage(ex.getMessage());
      errorDTO.setStatus( HttpStatus.BAD_REQUEST.name() );
      errorDTO.setTime(new Date().toString());

      return new ResponseEntity<>(errorDTO,HttpStatus.BAD_REQUEST);
  }
  
  
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ErrorCreateStudentException.class)
  public ResponseEntity<ErrorDTO> generateNotFoundException(ErrorCreateStudentException ex) {
      ErrorDTO errorDTO = new ErrorDTO();
      errorDTO.setMessage(ex.getMessage());
      errorDTO.setStatus( HttpStatus.BAD_REQUEST.name() );
      errorDTO.setTime(new Date().toString());

      return new ResponseEntity<>(errorDTO,HttpStatus.BAD_REQUEST);
  }
}
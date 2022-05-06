package com.example.exoClasse.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exoClasse.exceptions.ErrorCreateStudentException;
import com.example.exoClasse.model.Student;
import com.example.exoClasse.model.Subject;
import com.example.exoClasse.repository.StudentRepository;
import com.example.exoClasse.service.StudentService;

@RequestMapping("/api/exoclasse")
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	

	@GetMapping("/getstudents")
	public ResponseEntity<List<Student>> getStudents(){
		return studentService.getStudents();    
	    
	}
	
	private List<Student> students;
	
	@GetMapping("/getStudentByEmail/{email}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable String email){
		return studentService.getStudentByEmail(email);
	}   
	    
	
	@PostMapping("/createstudent")
	public ResponseEntity <String> createStudent(@Valid @RequestBody Student student) {
		try {
			studentRepository.save(student);
			return ResponseEntity.ok("L'étudiant a bien été crée !");
		}
		catch(RuntimeException e) {
			throw new ErrorCreateStudentException("L'étudiant n'a pas pu être crée dans la base !!!");
		}
		    
	    
	}
	
	
	 @PatchMapping("/patch/{email}")
	  public ResponseEntity<Object> update(@PathVariable String email, @RequestBody Student payload) {
	    return studentService.update(email, payload);
	  }
	 
	 @PostMapping("/createsubject")
	 public ResponseEntity<Subject> createSubject(@Valid @RequestBody Subject subject){
		 return studentService.createSubject(subject);
	 }
	 
	 @GetMapping("/getAvgAge")
	 public Double getAvgStudents(){
		 return studentService.getAvgStudent(students);
	 }
	 
	

}

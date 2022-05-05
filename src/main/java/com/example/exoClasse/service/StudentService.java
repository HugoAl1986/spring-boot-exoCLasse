package com.example.exoClasse.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.exoClasse.exceptions.EmailNotFoundException;
import com.example.exoClasse.exceptions.GetStudentsException;
import com.example.exoClasse.exceptions.StudentException;
import com.example.exoClasse.model.Student;
import com.example.exoClasse.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public ResponseEntity<Object> update(String email, @RequestBody Student payload) {
    try {
      final Optional<Student> optionalStudent = studentRepository.findByEmail(email);

      if (optionalStudent.isEmpty()) {
        throw new StudentException();
      }

      final Student student = optionalStudent.get();

      if (!payload.getEmail().isEmpty()) {
        student.setEmail(payload.getEmail());
      }
      final Boolean isNameProvided = payload.getName() != null && !payload.getName().isEmpty() && !payload.getName().isBlank();
      if (isNameProvided) {
        student.setName(payload.getName());
      }

      studentRepository.save(student);

      return ResponseEntity.ok(student);
    }
    catch (RuntimeException e) {
      throw new StudentException();
    }
  }
	
	public ResponseEntity<List<Student>> getStudents(){
		try {
			studentRepository.findAll();
		}catch(RuntimeException e){
			throw new GetStudentsException();
			
		}
		return ResponseEntity.ok().body(studentRepository.findAll());
	}
	
	public ResponseEntity<Optional<Student>> getStudentByEmail(@PathVariable String email){
		try {	
			final Optional <Student> student = studentRepository.findByEmail(email);
			if(student.isEmpty() || student == null) {
				throw new EmailNotFoundException();			
			}							
			return ResponseEntity.ok(student);			
		}catch(RuntimeException e){
			throw new EmailNotFoundException();			
		}
	}
}
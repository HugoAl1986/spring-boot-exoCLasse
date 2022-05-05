package com.example.exoClasse.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exoClasse.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	Optional<Student> findByEmail(String email);
	
}

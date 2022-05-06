package com.example.exoClasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exoClasse.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

}

package com.example.exoClasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exoClasse.model.Prof;

@Repository
public interface ProfRepository extends JpaRepository<Prof,Long>{

}

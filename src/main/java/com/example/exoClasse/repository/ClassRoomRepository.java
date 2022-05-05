package com.example.exoClasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exoClasse.model.ClassRoom;


@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom,Long>{
	
}

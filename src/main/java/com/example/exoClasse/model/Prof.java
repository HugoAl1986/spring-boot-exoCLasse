package com.example.exoClasse.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;



@Data
@Entity(name = "prof")
public class Prof {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable= false)
	private String name;
	
	@OneToOne(mappedBy="prof")
	private ClassRoom classroom;
	
}

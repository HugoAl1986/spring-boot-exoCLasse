package com.example.exoClasse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Data
@Entity(name="classroom")
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="description")
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="prof_id", referencedColumnName = "id")
    private Prof prof;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "classroom")
	private List <Student> students;
	
	
}

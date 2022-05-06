package com.example.exoClasse.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@Table(name = "student")
public class Student {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Column(name="name")
	private String name;
	
	@NotNull
	@Email(regexp = ".+[@].+[\\.].+", message = "Veuillez entrer un email valide !")
	@Column(name="email")
	private String email;
	
	
	@NotNull
	@Max(value=40, message = "Létudiant doit avoir moins de 40 ans")
	@Column(name="age")
	private Integer age;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "classRoom_id")
    private ClassRoom classroom;
	
	@ManyToMany
	@JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id"))
     private Set<Subject> subjects;
	
	

}

package com.example.exoClasse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.exoClasse.model.Student;
import com.example.exoClasse.service.AgeStudent;

@RunWith( JUnit4.class )
public class AgeTest {
	
	@Test
	public void testAgeOK() {
		Student student = new Student();
		student.setName("Paul");
		student.setAge(24);
		student.setEmail("paul@gmail.com");
		
		Student student2 = new Student();
		student2.setName("Vincent");
		student2.setAge(15);
		student2.setEmail("Vincent@gmail.com");
		
		AgeStudent agestudent;
		agestudent = new AgeStudent();
		
		assertEquals(true, agestudent.checkStudentAge(student));
		assertEquals(false, agestudent.checkStudentAge(student2));
	}
	
	
}



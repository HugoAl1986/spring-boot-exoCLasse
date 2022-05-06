package com.example.exoClasse.service;

import com.example.exoClasse.model.Student;

public class AgeStudent {
		
	public Boolean checkStudentAge(Student student) {
		if(student.getAge() > 18) {
			return true;
		}else{
			return false;
		}
	}
}



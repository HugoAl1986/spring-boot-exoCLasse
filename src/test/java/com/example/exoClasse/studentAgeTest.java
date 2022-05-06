package com.example.exoClasse;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.exoClasse.controller.StudentController;
import com.example.exoClasse.model.Student;
import com.example.exoClasse.repository.StudentRepository;
import com.example.exoClasse.service.StudentService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class) 
@WebMvcTest
@AutoConfigureMockMvc
public class studentAgeTest {
	
	@MockBean
	private StudentRepository studentRepository;
    
    @Autowired
    StudentController studentController;
	    
	@MockBean
	@Autowired
	StudentService studentService;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
    public void TestAvgStudent() throws Exception {
		
		/*
		Student student1 = new Student();
		student1.setAge(25);
		Student student2 = new Student();
		student2.setAge(35);
		
		List<Student>students = Arrays.asList(student1,student2);
		assertEquals(30, studentService.getAvgStudent(students));
		*/
		mockMvc.perform(MockMvcRequestBuilders.get("/api/exoclasse/getAvgAge"))
	     .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

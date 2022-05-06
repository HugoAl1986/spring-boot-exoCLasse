package com.example.exoClasse;

import java.nio.charset.Charset;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.exoClasse.controller.StudentController;
import com.example.exoClasse.repository.StudentRepository;
import com.example.exoClasse.service.StudentService;

@RunWith(SpringRunner.class) 
@WebMvcTest
@AutoConfigureMockMvc
class ExoClasseApplicationTests {
	
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
	    public void whenPostRequestAValidStudent_thenCorrectResponse() throws Exception {
	        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
	        String student = "{\"name\": \"Bill\", \"email\" : \"bob@domain.com\", \"age\" : 18}";
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/exoclasse/createstudent")
	          .content(student)
	          .contentType(MediaType.APPLICATION_JSON_UTF8))
	          .andExpect(MockMvcResultMatchers.status().isOk())
	          .andExpect(MockMvcResultMatchers.content()
	            .contentType(textPlainUtf8));
	    }
	
	@Test
	public void whenPostRequestAInvalidStudent_thenCorrectResponse() throws Exception {
		MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
	    String student = "{\"name\": \"\", \"email\" : \"bob@domaine.com\", \"age\" : 18}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/api/exoclasse/createstudent")
	      .content(student)
	      .contentType(MediaType.APPLICATION_JSON_UTF8))
	      .andExpect(MockMvcResultMatchers.status().is(400));
	    }
}



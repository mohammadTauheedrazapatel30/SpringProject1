package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.StudentEntity;
import com.example.springboot.service.StudentService;

// A RestController is an annotation using to create Web Services (Web Request + Web Responses)
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
    
	// Get Mapping is Used to create a get request using Spring
	@GetMapping("/home")
	public String hello() {
		return "Hello World ! This is Spring";
	}
	
	@GetMapping("/numbers")
	public int numbers() {
		
		int alpha = 3;
		
		try {
			 if(alpha == 4) { 
			 return 1;
			 }
		} catch(Exception e) {
			return 2;
		}finally {
		    return 3;	
		}
	}
	
	// Annotation using to give a Http Post Request Using spring
	// localhost:8080/home - api
	@PostMapping("/home")
	public StudentEntity addStudents(@RequestBody StudentEntity students) {
		this.studentService.addStudents(students);
		return students;
	}
}

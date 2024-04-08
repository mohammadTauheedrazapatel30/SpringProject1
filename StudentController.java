package com.example.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	// localhost:8080/list
	@GetMapping("/list")
    public List<StudentEntity> getAllStudents()
    {
        return studentService.findAll();
    }
	
	@GetMapping("/list/{id}")
	public Optional<StudentEntity> getStudentById(@PathVariable(value = "id") long id)
	    {
	        return studentService.findById(id);
	    }
	
	// localhost:8080/delete/{id}
//	@RequestMapping(method=RequestMethod.DELETE, value="delete/{id}")
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(value = "id") long id){
		// Optional is used when we want to run the method on null values !
		Optional<StudentEntity> existingStudent = studentService.findById(id);
		if(existingStudent.isPresent()) {
		   this.studentService.deleteStudent(existingStudent.get());
		   return ResponseEntity.ok("Deleted Successfully !");
		}
		return ResponseEntity.notFound().build();
	}
 
//	@PutMapping("update/{id}")
//	public ResponseEntity<StudentEntity> updateStudent(@PathVariable(value="id") long id, @RequestBody StudentEntity students){
//        StudentEntity updateStudent = studentService.updateStudent(id,students);
//		  return ResponseEntity.ok(updateStudent);
//	}
}

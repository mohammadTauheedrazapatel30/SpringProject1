package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.StudentRepository;
import com.example.springboot.entity.StudentEntity;

@Service
public class StudentService {
	
	// An annotaion for providing loose Coupling 
	// D.I. - using which we different objects can interact without any third party interface
    @Autowired
	private StudentRepository studentrepo;
    
    
    public StudentEntity addStudents(StudentEntity students) {
    	// we will save the data in mysql using this line 
    	studentrepo.save(students);
    	return students;
    }
}

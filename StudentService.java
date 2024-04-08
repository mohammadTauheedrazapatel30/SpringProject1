package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

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


	public List<StudentEntity> findAll() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}
    
	public Optional<StudentEntity> findById(long id) {
		return studentrepo.findById(id);
	}

    // As our method is void , we are not returning anything here and thus directing it to studentrepository
	public void deleteStudent(StudentEntity students) {
		// TODO Auto-generated method stub
		this.studentrepo.delete(students);	
	}

    public StudentEntity updateStudent(Long id, StudentEntity studentEntity) {
    	Optional<StudentEntity> existingStudent = studentrepo.findById(id);
    	if(existingStudent.isPresent()) {
    	   StudentEntity students = existingStudent.get();
    	   students.setAddress(studentEntity.getAddress());
    	   students.setContact(studentEntity.getContact());
    	   students.setDistrict(studentEntity.getDistrict());
    	   students.setEmail(studentEntity.getEmail());
    	   students.setName(studentEntity.getName());
    	   students.setState(studentEntity.getState());
    	   return studentrepo.save(students);
    	}else{
    		throw new RuntimeException();
    	}
    }
}

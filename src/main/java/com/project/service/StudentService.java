package com.project.service;

import java.util.List;

import com.project.entity.Student;

public interface StudentService {

	// create a new Student
	Student createStudent(Student student);
	
	//update student
	Student updateStudent(Student student, int id);
	
	//get a single Student
	Student getsingleStudent(int studentId);
	
	//get All Students
	List<Student> getAllStudent();
	
	//delete student
	void deleteStudent(int studentId);
	
	
}

package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Student;
import com.project.exception.ApiResponse;
import com.project.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<Student> newStudent(@RequestBody Student student){
		Student s = this.studentService.createStudent(student);
		return new ResponseEntity<Student>(s, HttpStatus.CREATED);
	}
	@PutMapping("/update/{studentId}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int studentId){
		Student s = this.studentService.updateStudent(student, studentId);
		return new ResponseEntity<Student>(s, HttpStatus.ACCEPTED);
	}
	@GetMapping("/singleStudent/{studentId}")
	public ResponseEntity<Student> getSingleStudent(@PathVariable int studentId){
		Student s = this.studentService.getsingleStudent(studentId);
		return new ResponseEntity<Student>(s, HttpStatus.OK);
	}
	
	@GetMapping("/allStudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		
		List<Student> list = this.studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable int studentId){
		this.studentService.deleteStudent(studentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Student deleted successfully",true), HttpStatus.OK);
	}
}

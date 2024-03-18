package com.project.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Repository.StudentRepository;
import com.project.entity.Student;
import com.project.service.StudentService;
import com.project.exception.*;

@Service
public class StuentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		
		Student s = this.studentRepository.save(student);
		return s;
		
	}

	@Override
	public Student updateStudent(Student student, int id) {
	
		Student s = this.studentRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Student", "StudentId", id));
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		s.setDepartmentt(student.getDepartmentt());
		s.setPhoneNo(student.getPhoneNo());
		s.setDate(student.getDate());
		Student s1 = this.studentRepository.save(s);
		return s1;
	}

	@Override
	public Student getsingleStudent(int studentId) {
		Student s = this.studentRepository.findById(studentId).orElseThrow(()-> new ResouceNotFoundException("Student", "StudentId", studentId));
		return s;
		
	}

	@Override
	public List<Student> getAllStudent() {
		
		List allStudent = this.studentRepository.findAll();
		
		return allStudent;
	}

	@Override
	public void deleteStudent(int studentId) {
		Student s = this.studentRepository.findById(studentId).orElseThrow(()-> new ResouceNotFoundException("Student", "StudentId", studentId));
		
		this.studentRepository.delete(s);
		

	}

}

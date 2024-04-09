package com.example.demo.controller;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class StudentController {

	private final StudentDao dao;

	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(@RequestBody Student student) {
		Student student2 = new Student();
		student2.setAmount(student.getAmount());
		student2.setCatagory(student.getCatagory());
		dao.save(student2);
		return ResponseEntity.ok("student saved successfully");
	}
	
	@GetMapping("/fetch/{id}")
	public Student fetchStudent(@PathVariable("id") Integer id) {
		return dao.findByEnrollment(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudentDetails(@PathVariable("id") Integer id,
			@RequestBody Student student) {
		Student student2= dao.findByEnrollment(id);
		student2.setAmount(student.getAmount());
		student2.setCatagory(student.getCatagory());
		dao.save(student2);
		return ResponseEntity.ok("student updated successfully");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable("id") Integer id){
		dao.deleteById(id);
		return ResponseEntity.ok("student deleted successfully");
	}

}

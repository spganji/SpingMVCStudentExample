package com.student.restapi;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.model.StudentReply;
import com.student.service.StudentMethods;

@RestController
public class StudentRestApi {

	@Autowired
	private StudentMethods stuMethods;
	
	//private StudentReply studentReply;
	
	
	@GetMapping(value="/getstudent")
	@ResponseBody
	public List<Student> getAllStudents(){
		//return stuMethods.getStudentRecords();
		return stuMethods.getStudentRecords();
	}
	
	@GetMapping(value="/getstudentfromdb")
	@ResponseBody
	public Student getStudent(@RequestParam("name") String name){
		//return stuMethods.getStudentRecords();
		return stuMethods.getStudent(name);
	}
	
	@GetMapping(value="/getstudentregfromdb")
	//@ResponseBody
	public Student getStudentreg(@RequestParam("reg") String reg){
		//return stuMethods.getStudentRecords();
		return stuMethods.getStudentreg(reg);
	}
	
	
	@PostMapping(value="/poststudent")
	public StudentReply postStudent(@RequestBody Student std)
	{
		stuMethods.add(std);
		//StudentReply studentReply = new StudentReply(std.getName(),std.getAge(),std.getName(),"Success");
		//return studentReply;
		return new StudentReply(std.getName(),std.getAge(),std.getRegistrationNumber(),"Success");
		
	}
	
	@PutMapping(value="/updatestudent")
	public String updateStudent(@RequestBody Student std) {
		return stuMethods.update(std);
		
	}
	@DeleteMapping(value="/deletestudent")
	public String deleteStudent(@RequestBody Student std) {
		System.out.println("Delete Successful");
		return stuMethods.delete(std);
	}
	
}

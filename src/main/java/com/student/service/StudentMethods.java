package com.student.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.StudentEntity;
import com.student.model.Student;
import com.student.repo.StudentRepo;

@Service
public class StudentMethods {

	// private static StudentMethods stdregd = null;
	private List<Student> studentRecords = new ArrayList<Student>();
	
	@Autowired
	private StudentRepo studentRepo;
	
	// = new ArrayList<Student>();

	// private StudentMethods(){
	// studentRecords = new ArrayList<Student>();
	// }

	/*
	 * public static StudentMethods getInstance() {
	 * 
	 * if(stdregd == null) { stdregd = new StudentMethods(); return stdregd; } else
	 * { return stdregd; } }
	 */

	public void add(Student std) {
		studentRecords.add(std);
		//StudentEntity entity = new StudentEntity(std.getName(),std.getAge(),std.getRegistrationNumber());
		StudentEntity entity = new StudentEntity();
		entity.setName(std.getName());
		entity.setAge(std.getAge());
		entity.setRegistrationNumber(std.getRegistrationNumber());
		studentRepo.save(entity);
	}

	public List<Student> getStudentRecords() {
		return studentRecords;
	}

	public String update(Student std) {

		for (int i = 0; i < studentRecords.size(); i++) {

			Student stdn = studentRecords.get(i);
			// if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
			if (stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
				studentRecords.set(i, std);
				return "Update successful";
			}

		}

		return "Update un-successful";
	}

	public String delete(Student std) {

		for (int i = 0; i < studentRecords.size(); i++) {

			Student stdn = studentRecords.get(i);
			// if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
			if (stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
				studentRecords.remove(i);
				return "Delete successful";
			}

		}

		return "Delete un-successful";
	}
	
	public Student getStudent(String name) {
		Optional<StudentEntity> stuEntityOpt = studentRepo.findByName(name);
		StudentEntity entity = stuEntityOpt.get();
		return new Student(entity.getName(),entity.getAge(),entity.getRegistrationNumber());
	}

	public Student getStudentreg(String reg) {
		Optional<StudentEntity> stuEntityOpt = studentRepo.findByregistrationNumber(reg);
		StudentEntity entity = stuEntityOpt.get();
		return new Student(entity.getName(),entity.getAge(),entity.getRegistrationNumber());
	}
		
	
}

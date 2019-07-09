package com.student.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;

@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, Long> {
	
	//<StudentEntity, Long> = Long is the primary key @Id, StudentEntity is the entity class
	Optional<StudentEntity> findByName(String Name);
	Optional<StudentEntity> findByregistrationNumber(String reg);
	
	
}
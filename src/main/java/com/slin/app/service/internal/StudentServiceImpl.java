package com.slin.app.service.internal;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.slin.app.entity.Student;
import com.slin.app.repo.StudentRepo;
import com.slin.app.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Collection<Student> getAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

}

package com.slin.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slin.app.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long>  {
	public List<Student> findByName (final String name);
}

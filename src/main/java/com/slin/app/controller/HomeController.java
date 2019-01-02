package com.slin.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slin.app.entity.Student;
import com.slin.app.service.StudentService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Collection<Student> getHome () {
		return studentService.getAll();
	}
}

package com.akhilesh.techademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.akhilesh.techademy.entity.Course;
import com.akhilesh.techademy.repository.CourseRepository;

@Controller
public class CourseController {
	@Autowired
	CourseRepository courseRepo;
	
	@GetMapping("/courseList")
	public String findAll(Model model) {
		model.addAttribute("courses", courseRepo.findAll());
		return "courseList";
	}
	
	@GetMapping("/newCourseForm")
	public String createUserForm(Model model) {
		model.addAttribute("course", new Course());
		return "newCourseForm";
	}

	@PostMapping("/createCourse")
	public String createUser(@ModelAttribute("course") Course course, @ModelAttribute("image") MultipartFile image, Model model) {

		System.out.println(course.toString());
		model.addAttribute("message", "Success or Failure");
		return "status";
	}
}

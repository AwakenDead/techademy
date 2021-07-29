package com.akhilesh.techademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.akhilesh.techademy.Service.ImageService;
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
	public String createCourseForm(Model model) {
		model.addAttribute("course", new Course());
		return "newCourseForm";
	}

	@PostMapping("/createCourse")
	public String createCourse(@ModelAttribute("course") Course course, Model model, MultipartFile image) {
		try {
			String filename = "course-" + course.getC_name() + "-" + course.getC_fees() + ".jpg";
			ImageService imgService = new ImageService();
			imgService.saveImage(image, filename);
			course.setC_resource(filename);
			courseRepo.save(course);
			model.addAttribute("message", "Course creation successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	@GetMapping("/updateCourseForm/{id}")
	public String updateCourseForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("course", courseRepo.getById(id));
		return "updateCourseForm";
	}

	@PostMapping("/updateCourse")
	public String updateCourse(@ModelAttribute("course") Course course, Model model, MultipartFile image) {
		try {
			String filename = "course-" + course.getC_name() + "-" + course.getC_fees() + ".jpg";
			ImageService imgService = new ImageService();
			imgService.saveImage(image, filename);
			course.setC_resource(filename);
			courseRepo.save(course);
			model.addAttribute("message", "Course updatation successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable("id") int id, Model model) {
		try {
			courseRepo.deleteById(id);
			model.addAttribute("message", "Admin deletion successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
}

package com.akhilesh.techademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akhilesh.techademy.entity.Admin;
import com.akhilesh.techademy.repository.AdminRepository;

@Controller
public class AdminController {
	@Autowired
	AdminRepository adminRepo;
	
	@GetMapping("/adminList")
	public String findAll(Model model) {
		model.addAttribute("admins", adminRepo.findAll());
		return "adminList";
	}
	
	@GetMapping("/newAdminForm")
	public String adminForm(Model model) {
		model.addAttribute("admin", new Admin());
		return "newAdminForm";
	}
	
	@PostMapping("/createAdmin")
	public String createAdmin(@ModelAttribute("admin") Admin admin, Model model) {
		try {
			adminRepo.save(admin);
			model.addAttribute("message", "Admin creation successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	@GetMapping("/updateAdminForm/{admin_id}")
	public String updateAdminForm(Model model, @PathVariable("admin_id") int id) {
		model.addAttribute("admin", adminRepo.getById(id));
		
		return "updateAdminForm";
	}
	
	@PostMapping("/updateAdmin")
	public String updateAdmin(@ModelAttribute("admin") Admin admin, Model model) {
//		System.out.println(admin);
		try {
			adminRepo.save(admin);
			model.addAttribute("message", "Admin update operation successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	@GetMapping("/deleteAdmin/{admin_id}")
	public String deleteAdmin(@PathVariable("admin_id") int id, Model model) {
		try {
			adminRepo.deleteById(id);
			model.addAttribute("message", "Admin deletion successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
}
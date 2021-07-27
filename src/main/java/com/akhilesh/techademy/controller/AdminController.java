package com.akhilesh.techademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String createAdmin(@ModelAttribute("admin") Admin admin) {
		System.out.println(admin.toString());
		return "status";
	}
}
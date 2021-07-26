package com.akhilesh.techademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.akhilesh.techademy.repository.AdminRepository;

@Controller
public class AdminController {
	@Autowired
	AdminRepository adminRepo;
	
	@GetMapping("/showAllAdmins")
	public String findAll(Model model) {
		model.addAttribute("admins", adminRepo.findAll());
		System.out.println(adminRepo.findAll().toString());
		return "adminList";
	}
}
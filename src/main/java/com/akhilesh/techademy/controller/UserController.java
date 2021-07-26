package com.akhilesh.techademy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.akhilesh.techademy.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/findAllUser")
	public String findAll(Model model) {
		model.addAttribute("users", userRepo.findAll());
		
//		List<User> users = userRepo.findAll();
		return "userList";
	}
}

package com.akhilesh.techademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.akhilesh.techademy.entity.User;
import com.akhilesh.techademy.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;

	@GetMapping("/userList")
	public String findAll(Model model) {
		model.addAttribute("users", userRepo.findAll());

//		List<User> users = userRepo.findAll();
		return "userList";
	}
	
	@GetMapping("/newUserForm")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		return "newUserForm";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("user") User user, @ModelAttribute("image") MultipartFile image, Model model) {

		System.out.println(user.toString());
		model.addAttribute("message", "Success or Failure");
		return "status";
	}
}

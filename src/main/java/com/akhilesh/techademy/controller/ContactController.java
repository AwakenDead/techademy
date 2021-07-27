package com.akhilesh.techademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.akhilesh.techademy.repository.ContactRepository;

@Controller
public class ContactController {
	@Autowired
	ContactRepository contactRepo;
	
	@GetMapping("/contactList")
	public String findAll(Model model) {
		model.addAttribute("contacts", contactRepo.findAll());
		return "contactList";
	}
}

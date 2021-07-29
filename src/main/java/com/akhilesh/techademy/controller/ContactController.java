//package com.akhilesh.techademy.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.akhilesh.techademy.entity.Contact;
//import com.akhilesh.techademy.repository.ContactRepository;
//
//@Controller
//public class ContactController {
//	@Autowired
//	ContactRepository contactRepo;
//	
//	@GetMapping("/contactList")
//	public String findAll(Model model) {
//		model.addAttribute("contacts", contactRepo.findAll());
//		return "contactList";
//	}
//	
//	@GetMapping("/newContactForm/{user_id}")
//	public String createContactForm(Model model) {
//		model.addAttribute("contact", new Contact());
//		return "newContactForm";
//	}
//	
//	@PostMapping("/createContact")
//	public String createContact(@ModelAttribute("contact") Contact contact) {
//		System.out.println(contact);
//		return "status";
//	}
//}

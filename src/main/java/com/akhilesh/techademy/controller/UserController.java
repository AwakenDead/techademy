package com.akhilesh.techademy.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.akhilesh.techademy.Service.ImageService;
import com.akhilesh.techademy.entity.Contact;
import com.akhilesh.techademy.entity.Feedback;
import com.akhilesh.techademy.entity.User;
import com.akhilesh.techademy.repository.ContactRepository;
import com.akhilesh.techademy.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ContactRepository contactRepo;
	
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
	public String createUser(@ModelAttribute("user") User user, @ModelAttribute("image") MultipartFile image, Model model) throws IOException {
		
		try {

			user.setReg_date(java.time.LocalDate.now()+"");
			
			String filename = "user-" + user.getName() + "-" + user.getPhone_no() + ".jpg";
			ImageService imgService = new ImageService();
			imgService.saveImage(image, filename);
//			
			user.setPhoto(filename);
			userRepo.save(user);
			model.addAttribute("message", "User creation successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		try {
			userRepo.deleteById(id);
			model.addAttribute("message", "User deletion successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	@GetMapping("/userProfile/{id}")
	public String userProfile(Model model, @PathVariable("id") int id) {
		User user = userRepo.getById(id);
		model.addAttribute("user", user);
		model.addAttribute("feedbacks", user.getFeedbacks());
		model.addAttribute("contacts", user.getContacts());
		return "userProfile";
	}
	
	@GetMapping("/updateUserForm/{id}")
	public String updateUserForm(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userRepo.getById(id));
		return "updateUserForm";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user, @ModelAttribute("image") MultipartFile image, Model model) {
		try {
			
			if(image != null) {
				String filename = "user-" + user.getName() + "-" + user.getPhone_no() + ".jpg";
			
				ImageService imgService = new ImageService();
				imgService.saveImage(image, filename);
	//			
				user.setPhoto(filename);
			}
			userRepo.save(user);
			model.addAttribute("message", "User updation successful.");
		}catch(Exception e){
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	
	@GetMapping("/contactList/{id}")
	public String findAllContact(Model model, @PathVariable("id") int id ) {
		model.addAttribute("contacts", userRepo.getById(id).getContacts() );
		return "contactList";
	}
	
	
	@GetMapping("/newContactForm/{id}")
	public String createContactForm(Model model, @PathVariable("id") int id) {
		User user = userRepo.getById(id);
		
		model.addAttribute("contact", new Contact());
		model.addAttribute("user_id", id);
		return "newContactForm";
	}
	
	@PostMapping("/createContact/{id}")
	public String createContact(@ModelAttribute("contact") Contact contact, @RequestParam("to_id") int to_id, Model model, @PathVariable("id") int id) {
//		System.out.println(to_id);
		try {
			User sender = userRepo.getById(id);
			User receiver = userRepo.getById(to_id);
			
			contact.setUser(receiver);
			contact.setEmail(sender.getEmail());
			contact.setName(sender.getName());
			contact.setPhone_no(sender.getPhone_no());
			
			receiver.addContact(contact);
			
			userRepo.save(receiver);
			
			model.addAttribute("message", "Contact creation successful.");
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("message", "Some Error Occured");
		}
		return "status";
	}
	
	@GetMapping("/newFeedbackForm/{user_id}")
	public String createFeedbackForm(Model model, @PathVariable("user_id") int id) {
		User user = userRepo.getById(id);
		
		Feedback f = new Feedback();
		
		f.setName(user.getName());
		f.setEmail(user.getEmail());
		
		model.addAttribute("f", f);
		model.addAttribute("user_id", id);
		
		return "newFeedbackForm";
	}
	
	@PostMapping("/createFeedback/{id}")
	public String createFeedback(@ModelAttribute("feedback") Feedback feedback, Model model, @PathVariable("id") int id) {
		try {
			User user = userRepo.getById(id);
			feedback.setUser(user);
			
			user.addFeedback(feedback);
			
			userRepo.save(user);
			
			model.addAttribute("message", "Feedback submission successful.");
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("message", "Some Error Occured");
		}
		
		return "status";
	}
}

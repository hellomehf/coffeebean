package com.setec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.setec.entites.Booked;
import com.setec.repos.BookedRepo;
import com.setec.services.MyTelegramBot;


import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	
	//http://localhost:8080/home
	@GetMapping({"/" , "/home"})
	public String home(Model mod) {
		Booked booked = new Booked(
				1,
				"Vong David",
				"12346789",
				"vid@gmail.com",
				"11/25/2025",
				"5:17 PM",
				5
					);
		mod.addAttribute("booked" , booked);
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/service")
	public String service() {
		return "service";
	}
	
	@GetMapping("/reservation")
	public String reservation(Model mod) {
		Booked booked = new Booked(
			1,
			"Vong David",
			"12346789",
			"vid@gmail.com",
			"11/25/2025",
			"5:17 PM",
			5
				);
		mod.addAttribute("booked" , booked);
		return "reservation";
	}
	
	@GetMapping("/testimonial")
	public String testimonial() {
		return "testimonial";
	}
	
	@Autowired
	private BookedRepo bookedRepo;
	
	@Autowired
	private MyTelegramBot bot;
	
	@PostMapping("/success")
	public String success(@ModelAttribute Booked booked) {
		bookedRepo.save(booked);
		bot.sendMessage("🔔 New Reservation Alert 🔔\n" +
		                "---------------------------------------------\n" +
		                "👤 Name : " + booked.getName() + "\n" +
		                "📧 Email: " + booked.getEmail() + "\n" +
		                "📅 Date: " + booked.getDate() + "\n" +
		                "⏰ Time: " + booked.getTime() + "\n" +
		                "📞 Contact: " + booked.getPhoneNumber() + "\n" +
		                "\n-------------------------------------------"
				);
		return "success";
	}
	

	
}

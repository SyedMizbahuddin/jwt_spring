package com.mizbah.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home")
@RestController
public class HomeController {

	@GetMapping("/users")
	public String getUser() {
		return "Fetched user details";
	}

	@GetMapping("/users/current")
	public String currentUser(Principal principal) {
		return principal.getName();
	}

}

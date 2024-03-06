package com.mizbah.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mizbah.dto.AuthenticationRequest;
import com.mizbah.dto.AuthenticationResponse;
import com.mizbah.dto.SignupRequest;
import com.mizbah.service.auth.AuthService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@RestController
public class AuthController {

	AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<AuthenticationResponse> signup(@RequestBody SignupRequest request) {

		return ResponseEntity.ok(authService.signup(request));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {

		log.info("Entered login");
		return ResponseEntity.ok(authService.login(request));
	}
}

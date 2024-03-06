package com.mizbah.service.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mizbah.config.JwtService;
import com.mizbah.dto.AuthenticationRequest;
import com.mizbah.dto.AuthenticationResponse;
import com.mizbah.dto.SignupRequest;
import com.mizbah.entity.Employee;
import com.mizbah.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthService {

	EmployeeRepository employeeRepository;
	PasswordEncoder passwordEncoder;
	JwtService jwtService;
	AuthenticationManager authenticationManager;

	public AuthenticationResponse signup(SignupRequest request) {
		Employee employee = Employee.builder().email(request.getEmail()).name(request.getName()).role(request.getRole())
				.password(passwordEncoder.encode(request.getPassword())).build();
		Employee createdEmployee = employeeRepository.save(employee);

		UserDetails user = User.builder().password(createdEmployee.getPassword()).username(createdEmployee.getEmail())
				.roles(createdEmployee.getRole().name()).build();

		String token = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(token).build();
	}

	public AuthenticationResponse login(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		// throws error here if not authenticated

		Employee employee = employeeRepository.findByEmail(request.getEmail());
		UserDetails user = User.builder().password(employee.getPassword()).username(employee.getEmail())
				.roles(employee.getRole().name()).build();

		String token = jwtService.generateToken(user);
		return AuthenticationResponse.builder().token(token).build();

	}

}

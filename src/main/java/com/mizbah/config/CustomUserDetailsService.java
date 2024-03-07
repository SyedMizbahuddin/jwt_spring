package com.mizbah.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mizbah.entity.Employee;
import com.mizbah.repository.EmployeeRepository;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByEmail(username);
		if (employee == null) {
			throw new UsernameNotFoundException("User with email not found: " + username);
		}

		UserDetails userDetails = User.builder().username(employee.getEmail()).password(employee.getPassword())
				.roles(employee.getRole().name()).build();
		return userDetails;
	}

}

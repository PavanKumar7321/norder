package com.ensar.norder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensar.norder.entity.User;
import com.ensar.norder.service.service.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@GetMapping
	public List<User> getAllUsers() {
		return userDetailsService.getAllUsers();
	}

	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable String id) {
		return userDetailsService.getUserById(id);
	}
}

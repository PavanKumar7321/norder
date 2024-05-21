package com.ensar.norder.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
  private String email;

	@NotBlank
	private String password;

	public String getUsername() {
		return email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

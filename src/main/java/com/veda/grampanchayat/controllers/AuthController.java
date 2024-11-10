package com.veda.grampanchayat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veda.grampanchayat.dtos.UserDto;
import com.veda.grampanchayat.entities.JwtResponse;
import com.veda.grampanchayat.securities.AuthService;
import com.veda.grampanchayat.securities.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDTO) {
		String token = authService.authenticate(userDTO);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDto userDTO) {
		authService.register(userDTO);
		return ResponseEntity.ok("User registered successfully");
	}

	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		return ResponseEntity.ok("Logout successful");
	}
	
	 @PostMapping("/refresh-token")
	    public ResponseEntity<?> refreshToken(@RequestBody String refreshToken) {
	        String newAccessToken = jwtUtil.refreshAccessToken(refreshToken);

	        if (newAccessToken != null) {
	            return ResponseEntity.ok(new JwtResponse(newAccessToken));
	        } else {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid refresh token");
	        }
	    }

}

package com.veda.grampanchayat.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.veda.grampanchayat.dtos.UserDto;
import com.veda.grampanchayat.entities.User;
import com.veda.grampanchayat.repos.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String authenticate(UserDto userDTO) {
		User user = userRepository.findByUsername(userDTO.getUsername())
				.orElseThrow(() -> new RuntimeException("User not found"));

		if (passwordEncoder.matches( userDTO.getPassword(),user.getPassword())) {
			return jwtUtil.generateToken(user.getUsername());
		} else {
			throw new RuntimeException("Invalid username or password");
		}
	}

	public User register(UserDto userDto) {
		User newUser = new User();
		newUser.setUsername(userDto.getUsername());
		newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
		return userRepository.save(newUser);
	}

}

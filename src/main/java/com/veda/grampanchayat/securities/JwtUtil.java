package com.veda.grampanchayat.securities;

import java.sql.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private final String SECRET_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCD";

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new java.util.Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public String generateRefreshToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new java.util.Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 100))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	public boolean isTokenValid(String token, String username) {
		return (username.equals(extractUsername(token)) && !isTokenExpired(token));
	}

	public boolean isRefreshTokenValid(String token, String username) {
		return (username.equals(extractUsername(token)) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return extractAllClaims(token).getExpiration().before(new java.util.Date());
	}

	public String refreshAccessToken(String refreshToken) {
		String username = extractUsername(refreshToken);

		if (isRefreshTokenValid(refreshToken, username)) {
			return generateToken(username);
		} else {
			return null;
		}
	}

}

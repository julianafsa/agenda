package br.com.santander.agenda.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${jwt.token.expiration}")
	private Long expirationTime;
	
	@Value("${jwt.token.secret}")
	private String secret;

	public String getToken(Authentication authentication) {
		Date issueAt = new Date();
		Date expirationDate = new Date(issueAt.getTime() + expirationTime);
		
		return Jwts.builder()
			.setIssuer("API de Agenda")
			.setSubject(authentication.getName())
			.setIssuedAt(issueAt)
			.setExpiration(expirationDate)
			.signWith(SignatureAlgorithm.HS512, secret)
			.compact();
	}

	public boolean isValidToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String getUserEmail(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}

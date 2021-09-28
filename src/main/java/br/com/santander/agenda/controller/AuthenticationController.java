package br.com.santander.agenda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.agenda.config.security.TokenService;
import br.com.santander.agenda.model.dto.TokenDto;
import br.com.santander.agenda.model.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	// Para disparar manualmente o processo de autenticação no Spring Security via username/password
	@Autowired
	AuthenticationManager authenticationManager; 
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm loginForm) {
		UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.getToken(authenticate);
			// Bearer é um dos mecanismos de autenticação utilizados no protocolo HTTP, tal como o Basic e o Digest.
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
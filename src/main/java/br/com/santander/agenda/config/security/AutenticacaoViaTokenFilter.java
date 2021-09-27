package br.com.santander.agenda.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.santander.agenda.model.User;
import br.com.santander.agenda.repository.UserRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	private UserRepository userRepository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UserRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.userRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
		// Obtém o token
		String token = recuperarToken(request);
		
		boolean valido = tokenService.isValidToken(token);
		
		if (valido) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarCliente(String token) {
		String username = tokenService.getUserEmail(token);
		User user = userRepository.findByEmail(username).get();
		UsernamePasswordAuthenticationToken authentication = 
			new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
 		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		 
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}

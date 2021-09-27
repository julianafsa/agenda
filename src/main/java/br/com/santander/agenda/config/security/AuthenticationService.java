package br.com.santander.agenda.config.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.santander.agenda.model.User;
import br.com.santander.agenda.service.UserService;

/**
 * Classe service que executa a lógica de autenticação.
 * Ela consulta o usuário no banco de dados.
 * Ela valida as credenciais de um cliente que está se autenticando.
 */

@Service
public class AuthenticationService implements UserDetailsService {

	private final UserService userService;

	public AuthenticationService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userService.findUserByEmail(username);
		if (user.isPresent()) {
			return user.get();
		}
		throw new UsernameNotFoundException("User not found");
	}

}
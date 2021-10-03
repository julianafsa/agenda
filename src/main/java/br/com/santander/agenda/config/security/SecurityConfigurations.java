package br.com.santander.agenda.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.santander.agenda.service.UserService;

@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	private final AuthenticationService authService;
	
	private final TokenService tokenService;
	
	private final UserService userService;
	
	@Autowired
	public SecurityConfigurations(AuthenticationService authService,
		TokenService tokenService, UserService userService) {
		this.authService = authService;
		this.tokenService = tokenService;
		this.userService  = userService;
	}
	
	/**
	 * Para poder injetar o AuthenticationManager no controller.
	 */
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	/**
	 * Configurações de Autenticação.
	 * Indica ao Spring Security qual o algoritmo de hashing de senha que utilizaremos na API,
	 *  chamando o método passwordEncoder().
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authService).passwordEncoder(encoder());
	}
	
	/**
	 * Configurações de Autorização.
	 * Libera acesso aos endpoints da API.
	 * O método http.authorizeRequests().antMatchers().permitAll libera acesso a algum 
	 *  endpoint da API.
	 * O método anyRequest().authenticated() indica ao Spring Security para bloquear 
	 *  todos os endpoints que não foram liberados anteriormente com o método permitAll.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers(HttpMethod.POST, "/auth").permitAll()
//		.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
//		.anyRequest().authenticated() // Qualquer outra requisição tem que estar autenticada
//		.and().csrf().disable() // Desabilitando proteção CSRF
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Configurando a autenticação stateless no Spring Security
//		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class); // Para registrar o filtro no Spring
//		http
//		.cors().disable()
//		.csrf().disable()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and().headers().frameOptions().sameOrigin()
//		.and().authorizeRequests().antMatchers("/h2-console/**", "/auth/**", "/actuator/**").permitAll()
//		.anyRequest().authenticated()
//		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, userService),UsernamePasswordAuthenticationFilter.class);	
		http
		.antMatcher("/**").authorizeRequests()
		.antMatchers("/", "/user").permitAll()
		.anyRequest().authenticated()
		.and().oauth2Login()
		.defaultSuccessUrl("/bloqueada");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	        .antMatchers("/**.html", 
	        		     "/v2/api-docs", 
	        		     "/webjars/**", 
	        		     "/configuration/**", 
	        		     "/swagger-resources/**",
	        		     "/swagger-ui/**");
	}
	
	@Bean
	protected BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}


}
package com.Distribuidora.security;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(
	                "/login.html",
	                "/css/**",
	                "/js/**"
	            ).permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin(form -> form
	            .loginPage("/login.html")
	            .loginProcessingUrl("/login")
	            .defaultSuccessUrl("/", true)
	            .permitAll()
	        )
	        .logout(logout -> logout
	        	.logoutUrl("/logout")
	            .logoutSuccessUrl("/login.html")
	            .invalidateHttpSession(true)
	            .deleteCookies("JSESSIONID")
	            .permitAll()
	        );

	    return http.build();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(); //metodo de hashing aplicado
	}


	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		String password = encoder.encode("MyCode0451");
		UserDetails user = User.withUsername("managerDistribuidora")  	//User class pertenece a spring secutiry
				.password(password)
				.roles("USER").build(); //Admin innecesario para la escala del producto
		return new InMemoryUserDetailsManager(user);
	}
	
	public WebSecurityConfig() {
	}

}

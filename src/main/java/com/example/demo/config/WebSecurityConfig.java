package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
@EnableWebSecurity
public class WebSecurityConfig {

	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean("beancomponen")
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

		http.
				authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/registration/user","/upload/**", "/src/main/uploads/**").permitAll()
				.antMatchers("/admin/**").access("hasRole('ADMIN')")
				.antMatchers("/showFiles").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("email")
				.permitAll()
				.and()
				.logout()
				.permitAll();

		return http.build();
	}

	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

	}
}
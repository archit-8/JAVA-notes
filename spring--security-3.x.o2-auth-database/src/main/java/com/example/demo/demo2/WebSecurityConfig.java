
/*package com.example.demo.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

		manager.createUser(
				User.withUsername("user").password(passwordEncoder.encode("password")).roles("USER").build());

		manager.createUser(
				User.withUsername("admin").password(passwordEncoder.encode("admin123")).roles("ADMIN").build());

		return manager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/actuator/health", "/loan/api/v1.0/fetch/**")
						.permitAll().requestMatchers("/loan/api/v1.0/create", "/loan/api/v1.0/modify**")
						.hasAnyRole("USER", "ADMIN").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}
}*/

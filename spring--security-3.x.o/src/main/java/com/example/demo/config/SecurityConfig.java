package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(customizer -> customizer.disable());
		// http.authorizeHttpRequests(request-> request.anyRequest().authenticated());
		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/root/all").permitAll());
		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/root/inbox").hasRole("USER"));
		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/root/management").hasRole("ADMIN"));
		http.formLogin(Customizer.withDefaults()); // follow form login approach
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
		//when session is  stateless don't enable  fromlogin .in browser when we access url
		// Browser will pop-up a login dialog
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("admin123").roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user, user2);

	}

}
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception  {
//      
//    	    http.authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll());
//            return http.build();
//    }
//}

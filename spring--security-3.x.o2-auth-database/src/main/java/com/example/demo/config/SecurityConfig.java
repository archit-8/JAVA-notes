package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MyUserDetailService myUserDetailsService;

	@Autowired
	static PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	};

//    private final UserDetailsService userDetailsService;

//

//    private final UserDetailsService userDetailsService;

//    SecurityConfig(UserDetailsService userDetailsService) {

//        this.userDetailsService = userDetailsService;

//    }

//    

//	

//

//    SecurityConfig(UserDetailsService userDetailsService) {

//        this.userDetailsService = userDetailsService;

//    }

//	

	@Bean

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		http.authorizeHttpRequests((authorize)->authorize.anyRequest().permitAll());

//		http.csrf(customizer -> customizer.disable());

//        http.authorizeHttpRequests(request->request.anyRequest().authenticated());

		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/root/inbox").hasRole("USER"));

		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/root/management").hasRole("ADMIN"));

		http.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/root/all").hasAnyRole("ADMIN", "USER"));

		http.formLogin(Customizer.withDefaults());// follow form login approach

		http.httpBasic(Customizer.withDefaults());

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

		// When session is stateless don't enable form login, in browser when we access
		// url browser will popup up a login window

		// when we disable form login the acess from postman is unaffected

		return http.build();

	}

//	 @Bean

//     public UserDetailsService userDetailsService() {

//             UserDetails user = User.withDefaultPasswordEncoder()

//                     .username("root")

//                     .password("root123")

//                     .roles("USER").build();

//             UserDetails user2 = User.withDefaultPasswordEncoder()

//                     .username("admin")

//                     .password("admin123").roles("ADMIN")

//                     .build();

//             return new InMemoryUserDetailsManager(user,user2);

//     }

	@Bean

	public MyUserDetailService userDetailsService() {

		return myUserDetailsService;

	}

	@Bean

	AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

		provider.setPasswordEncoder(passwordEncoder());

		provider.setUserDetailsService(myUserDetailsService);

		return provider;

	}

	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

		return config.getAuthenticationManager();

	}

}

/*
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception {
 * 
 * http.csrf(customizer -> customizer.disable()); //
 * http.authorizeHttpRequests(request-> request.anyRequest().authenticated());
 * http.authorizeHttpRequests((authorize) ->
 * authorize.requestMatchers("/root/all").permitAll());
 * http.authorizeHttpRequests((authorize) ->
 * authorize.requestMatchers("/root/inbox").hasRole("USER"));
 * http.authorizeHttpRequests((authorize) ->
 * authorize.requestMatchers("/root/management").hasRole("ADMIN"));
 * http.formLogin(Customizer.withDefaults()); // follow form login approach
 * http.httpBasic(Customizer.withDefaults()); http.sessionManagement(session ->
 * session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)); //when session
 * is stateless don't enable fromlogin .in browser when we access url // Browser
 * will pop-up a login dialog // when we disable form login the access from the
 * postman is unaffected return http.build(); }
 * 
 * @Bean public UserDetailsService userDetailsService() { UserDetails user =
 * User.withDefaultPasswordEncoder().username("user").password("password").roles
 * ("USER") .build();
 * 
 * UserDetails user2 =
 * User.withDefaultPasswordEncoder().username("admin").password("admin123").
 * roles("USER") .build(); return new InMemoryUserDetailsManager(user, user2);
 * 
 * }
 * 
 * }
 */

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

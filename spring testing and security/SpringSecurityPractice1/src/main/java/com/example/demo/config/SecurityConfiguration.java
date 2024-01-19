package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(httpReq -> httpReq.requestMatchers("/all").permitAll()
				.requestMatchers("/user").hasAnyRole("user","admin")
				.requestMatchers("/admin").hasRole("admin")).a
				
		; */
		
		System.out.println("in security config");
		
		http.csrf(csrf -> csrf.disable())
	   .authorizeHttpRequests((authorize) -> {
        	authorize.requestMatchers("/all").permitAll();
        	authorize.requestMatchers("/login").permitAll();
        	authorize.requestMatchers("/logout").permitAll();
            authorize.requestMatchers("/user").hasAnyRole("user","admin");
            authorize.requestMatchers("/admin").hasRole("admin");
        })
        .httpBasic(Customizer.withDefaults());
		return http.build();
		
		//return http.build();
	}
	
	@Bean
	UserDetailsService createUsers()
	{
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("password"))
				.roles("user")
				.build();
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("admin","user")
				.build();
		return new InMemoryUserDetailsManager(user,admin);
		
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	
	
	

}  



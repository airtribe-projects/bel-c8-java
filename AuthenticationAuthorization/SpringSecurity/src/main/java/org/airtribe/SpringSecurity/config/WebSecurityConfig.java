package org.airtribe.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(11);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // Disable CSRF if necessary
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/register", "/verifyRegistration").permitAll() // Allow unauthenticated access to /register
                .anyRequest().authenticated() // Require authentication for other requests
        )
        .formLogin(formLogin ->
            formLogin
                .loginPage("/login") // Specify login page if needed
                .permitAll()
        )
        .logout(logout ->
            logout.permitAll()
        );

    return http.build();
  }
}

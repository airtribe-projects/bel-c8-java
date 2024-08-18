package org.airtribe.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
        .oauth2Login(oauth2Login -> {
          oauth2Login.loginPage("/oauth2/authorization/api-client-oidc");
          oauth2Login.defaultSuccessUrl("/api/hello", true);
        }) // Enable OAuth2 login
        .oauth2Client(Customizer.withDefaults());

    return http.build();
  }
}

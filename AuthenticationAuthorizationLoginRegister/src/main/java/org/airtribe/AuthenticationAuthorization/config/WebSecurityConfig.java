package org.airtribe.AuthenticationAuthorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

  @Bean
  public PasswordEncoder _passwordEncoder() {
    return new BCryptPasswordEncoder(11);

  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorizeRequests ->  authorizeRequests.requestMatchers("/register", "/login", "/api/hello")
            .permitAll().anyRequest().authenticated())
        .formLogin(formLogin -> formLogin.defaultSuccessUrl("/api/hello", true).permitAll());

    return http.build();
  }
}

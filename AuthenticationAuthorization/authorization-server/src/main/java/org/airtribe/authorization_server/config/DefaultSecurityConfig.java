package org.airtribe.authorization_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.*;

@Configuration
@EnableWebSecurity
public class DefaultSecurityConfig {

  @Bean
  public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/.well-known/openid-configuration", "/oauth2/.well-known/openid-configuration", "/error", "/webjars/**", "/favicon.ico").permitAll()
                .anyRequest().authenticated()
        )
        .formLogin(withDefaults());
    return http.build();
  }
}

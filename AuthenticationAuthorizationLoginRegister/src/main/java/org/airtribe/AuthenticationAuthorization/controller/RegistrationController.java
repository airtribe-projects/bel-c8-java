package org.airtribe.AuthenticationAuthorization.controller;

import jakarta.validation.Valid;
import org.airtribe.AuthenticationAuthorization.entity.User;
import org.airtribe.AuthenticationAuthorization.model.LoginRequest;
import org.airtribe.AuthenticationAuthorization.model.UserModel;
import org.airtribe.AuthenticationAuthorization.service.UserService;
import org.airtribe.AuthenticationAuthorization.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

  @Autowired
  private UserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/register")
  public User register(@Valid @RequestBody UserModel user) {
    return userService.register(user);
  }

  @GetMapping("/api/hello")
  public String hello() {
    return "Hello from auth";
  }

  @PostMapping("/signin")
  public String login(@RequestBody LoginRequest loginRequest) {
    try {
      String username = loginRequest.getUsername();
      String password = loginRequest.getPassword();
      boolean isAuthenticated = userService.authenticateUser(username, password);

      if (isAuthenticated) {
        return JwtUtil.generateToken(loginRequest.getUsername());
      } else {
        throw new RuntimeException("Invalid credentials");
      }
    } catch (AuthenticationException e) {
      throw new RuntimeException("Invalid credentials", e);
    }
  }
}
package org.airtribe.AuthenticationAuthorization.controller;

import jakarta.validation.Valid;
import org.airtribe.AuthenticationAuthorization.entity.User;
import org.airtribe.AuthenticationAuthorization.model.LoginRequest;
import org.airtribe.AuthenticationAuthorization.model.UserModel;
import org.airtribe.AuthenticationAuthorization.service.UserService;
import org.airtribe.AuthenticationAuthorization.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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


  @PostMapping("/signin")
  public String login(@RequestBody LoginRequest loginRequest) {
    try {
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
      );

      if (authentication.isAuthenticated()) {
        return JwtUtil.generateToken(loginRequest.getUsername());
      } else {
        throw new RuntimeException("Invalid credentials");
      }
    } catch (AuthenticationException e) {
      throw new RuntimeException("Invalid credentials", e);
    }
  }

  @PostMapping("/register")
  public User register(@Valid @RequestBody UserModel user) {
    return userService.register(user);
  }

  @GetMapping("/api/hello")
  public String hello() {
    return "Hello from auth";
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleException(RuntimeException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
  }
}


package org.airtribe.AuthenticationAuthorization.controller;

import jakarta.validation.Valid;
import org.airtribe.AuthenticationAuthorization.entity.User;
import org.airtribe.AuthenticationAuthorization.model.UserModel;
import org.airtribe.AuthenticationAuthorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User register(@Valid @RequestBody UserModel user) {
    return userService.register(user);
  }

  @GetMapping("/api/hello")
  public String hello() {
    return "Hello from auth";
  }
}


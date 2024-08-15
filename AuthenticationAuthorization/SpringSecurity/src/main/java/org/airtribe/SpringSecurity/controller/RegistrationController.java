package org.airtribe.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import org.airtribe.SpringSecurity.entity.User;
import org.airtribe.SpringSecurity.model.UserModel;
import org.airtribe.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegistrationController {

  @Autowired
  private UserService _userService;

  @PostMapping("/register")
  public User register(@RequestBody UserModel user, HttpServletRequest request) {
    User userEntity =  _userService.registerUser(user);
    String token = UUID.randomUUID().toString();
    String applicationUrl = getApplicationUrl(request) + "/verifyRegistration?token=" + token;
    _userService.createVerificationToken(userEntity, token);
    System.out.println("Verification token created for user: " + userEntity.getEmail());
    System.out.println("Verification url: " + applicationUrl);
    return userEntity;
  }

  @PostMapping("/verifyRegistration")
  public String verifyRegistration(@RequestParam String token) {
    boolean isValid = _userService.validateTokenAndEnableUser(token);
    if (!isValid) {
      return "Invalid token";
    }
    return "User enabled successfully";
  }


  private String getApplicationUrl(HttpServletRequest request) {
    return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
  }

}

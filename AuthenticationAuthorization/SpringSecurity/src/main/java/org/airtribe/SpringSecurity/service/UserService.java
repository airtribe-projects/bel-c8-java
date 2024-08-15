package org.airtribe.SpringSecurity.service;

import org.airtribe.SpringSecurity.entity.User;
import org.airtribe.SpringSecurity.model.UserModel;


public interface UserService {
  User registerUser(UserModel user);

  void createVerificationToken(User userEntity, String token);

  boolean validateTokenAndEnableUser(String token);
}

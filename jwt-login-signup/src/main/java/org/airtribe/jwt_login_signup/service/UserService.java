package org.airtribe.jwt_login_signup.service;

import org.airtribe.jwt_login_signup.entity.User;
import org.airtribe.jwt_login_signup.exception.TokenExpiredException;
import org.airtribe.jwt_login_signup.model.LoginDto;
import org.airtribe.jwt_login_signup.model.UserModel;


public interface UserService {
  User registerUser(UserModel userModel);

  User autheticateUser(LoginDto loginDto);

  void createVerificationToken(User user, String token);

  boolean validateTokenAndEnableUser(String token) throws TokenExpiredException;

  String createNewVerificationTokenAndInvalidateOldToken(String oldToken);
}

package org.airtribe.AuthenticationAuthorization.service;

import org.airtribe.AuthenticationAuthorization.entity.User;
import org.airtribe.AuthenticationAuthorization.model.UserModel;
import org.airtribe.AuthenticationAuthorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

  @Autowired
  private UserRepository _userRepository;

  @Autowired
  private PasswordEncoder _passwordEncoder;

  public User register(UserModel user) {
    User databaseUser = new User();
    databaseUser.setEmail(user.getEmail());
    databaseUser.setName(user.getName());
    databaseUser.setPassword(_passwordEncoder.encode(user.getPassword()));
    databaseUser.setRole("USER");
    databaseUser.setEnabled(false);
    return _userRepository.save(databaseUser);

  }
}

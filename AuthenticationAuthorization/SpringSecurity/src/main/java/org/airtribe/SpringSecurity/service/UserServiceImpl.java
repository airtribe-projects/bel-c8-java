package org.airtribe.SpringSecurity.service;

import org.airtribe.SpringSecurity.entity.User;
import org.airtribe.SpringSecurity.entity.VerificationToken;
import org.airtribe.SpringSecurity.model.UserModel;
import org.airtribe.SpringSecurity.repository.UserRepository;
import org.airtribe.SpringSecurity.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private VerificationTokenRepository _verificationTokenRepository;

  @Autowired
  private PasswordEncoder _passwordEncoder;

  @Override
  public User registerUser(UserModel user) {
    User userEntity = new User();
    userEntity.setEmail(user.getEmail());
    userEntity.setFirstName(user.getFirstName());
    userEntity.setLastName(user.getLastName());
    userEntity.setPassword(_passwordEncoder.encode(user.getPassword()));
    userEntity.setRole("USER");
    userEntity.setEnabled(false);
    userRepository.save(userEntity);
    return userEntity;
  }

  @Override
  public void createVerificationToken(User userEntity, String token) {
    VerificationToken verificationToken = new VerificationToken(token, userEntity);
    _verificationTokenRepository.save(verificationToken);
  }

  @Override
  public boolean validateTokenAndEnableUser(String token) {
    VerificationToken verificationToken = _verificationTokenRepository.findByToken(token);
    if (verificationToken == null) {
      return false;
    }
    if (verificationToken.getExpirationTime().getTime() > System.currentTimeMillis()) {
      User user = verificationToken.getUser();
      if (!user.isEnabled()) {
        user.setEnabled(true);
        userRepository.save(user);
        _verificationTokenRepository.delete(verificationToken);
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}

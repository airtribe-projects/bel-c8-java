package org.airtribe.AuthenticationAuthorization.service;

import java.util.List;
import org.airtribe.AuthenticationAuthorization.entity.User;
import org.airtribe.AuthenticationAuthorization.model.UserModel;
import org.airtribe.AuthenticationAuthorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

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

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = _userRepository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new org.springframework.security.core.userdetails.User(
        user.getName(),
        user.getPassword(),
        List.of(new SimpleGrantedAuthority(user.getRole()))
    );
  }

  public boolean authenticateUser(String username, String password) {
    // Find user from repository
    User user = _userRepository.findByEmail(username);

    if (user != null && _passwordEncoder.matches(password, user.getPassword())) {
      // Create an authentication object
      UserDetails userDetails = loadUserByUsername(username);
      Authentication authentication = new UsernamePasswordAuthenticationToken(
          userDetails, password, userDetails.getAuthorities()
      );

      // Manually set the authentication in SecurityContext
      SecurityContextHolder.getContext().setAuthentication(authentication);
      return true;
    }
    return false; // Authentication failed
  }
}
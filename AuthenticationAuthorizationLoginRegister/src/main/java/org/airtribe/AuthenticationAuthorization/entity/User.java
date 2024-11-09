package org.airtribe.AuthenticationAuthorization.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;


@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  private String name;

  @Email
  private String email;

  private String password;

  private boolean isEnabled;

  private String role;

  public User() {
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public User(Long userId, String name, String email, String password, boolean isEnabled, String role) {
    this.userId = userId;
    this.name = name;
    this.email = email;
    this.password = password;
    this.isEnabled = isEnabled;
    this.role = role;
  }
}

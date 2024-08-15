package org.airtribe.SpringSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
  private String firstName;
  private String lastName;

  private String email;

  private String password;
}

package org.airtribe.jwt_login_signup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class VerificationToken {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String token;

  private Date expirationTime;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(nullable = false, name = "userId")
  private User user;

  public VerificationToken(String token, User user) {
    this.token = token;
    this.user = user;
    this.expirationTime = calculateExpirationTime();
  }

  public VerificationToken(String token) {
    this.token = token;
    this.expirationTime = calculateExpirationTime();
  }

  public static Date calculateExpirationTime() {
    long expirationTimeInMinutes = 10;
    long expirationTimeInMilliseconds = expirationTimeInMinutes * 60 * 1000;
    return new Date(System.currentTimeMillis() + expirationTimeInMilliseconds);
  }

}

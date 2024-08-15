package org.airtribe.SpringSecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;
import javax.annotation.processing.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerificationToken {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long tokenId;

  private String token;

  private java.util.Date expirationTime;

  @OneToOne(fetch = jakarta.persistence.FetchType.EAGER)
  @JoinColumn(nullable = false, name = "userId")
  private User user;

  public VerificationToken(String token, User user) {
    this.token = token;
    this.user = user;
    this.expirationTime = calculateExpirationTime();
  }

  public Date calculateExpirationTime() {
    long expirationTimeInMinutes = 20;
    long expirationTimeInMilliseconds = expirationTimeInMinutes * 60 * 1000;
    return new Date(System.currentTimeMillis() + expirationTimeInMilliseconds);
  }
}

package org.airtribe.authorization_server.repository;

import org.airtribe.authorization_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}

package org.airtribe.jwt_login_signup.repository;

import java.util.Optional;
import org.airtribe.jwt_login_signup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}

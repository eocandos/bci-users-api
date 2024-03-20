package cl.com.users.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.com.users.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  boolean existsByEmail(String email);

  User findByEmail(String email);


}

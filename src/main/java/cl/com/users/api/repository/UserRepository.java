package cl.com.users.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.com.users.api.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    boolean existsByEmail(String email);

    AppUser findByEmail(String email);


}

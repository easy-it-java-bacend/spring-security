package kg.itschool.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kg.itschool.demo.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
}
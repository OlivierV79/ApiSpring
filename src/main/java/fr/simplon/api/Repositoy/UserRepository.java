package fr.simplon.api.Repositoy;

import fr.simplon.api.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    public Optional<User> findByUsername(String username);
}

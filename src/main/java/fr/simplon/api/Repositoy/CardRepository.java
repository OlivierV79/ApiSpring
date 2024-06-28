package fr.simplon.api.Repositoy;

import fr.simplon.api.Models.Card;
import fr.simplon.api.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}

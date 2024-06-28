package fr.simplon.api.Repositoy;

import fr.simplon.api.Models.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line, Integer> {
}

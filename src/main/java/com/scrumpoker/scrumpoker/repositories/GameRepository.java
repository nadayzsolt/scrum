package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.Game;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
  List<Game> findAll();
}

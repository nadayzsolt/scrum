package com.scrumpoker.scrumpoker.services;

import com.scrumpoker.scrumpoker.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
  private final GameRepository gameRepository;

  @Autowired
  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }
}

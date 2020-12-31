package com.scrumpoker.scrumpoker.services;

import com.scrumpoker.scrumpoker.repositories.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintService {
  private final SprintRepository sprintRepository;

  @Autowired
  public SprintService(SprintRepository sprintRepository) {
    this.sprintRepository = sprintRepository;
  }
}

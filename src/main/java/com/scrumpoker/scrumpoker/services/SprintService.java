package com.scrumpoker.scrumpoker.services;

import com.scrumpoker.scrumpoker.models.Sprint;
import com.scrumpoker.scrumpoker.repositories.SprintRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintService {
  private final SprintRepository sprintRepository;

  @Autowired
  public SprintService(SprintRepository sprintRepository) {
    this.sprintRepository = sprintRepository;
  }

  public void addSprint(String sprintCode){
    sprintRepository.save(new Sprint(sprintCode));
  }

  public List<String> getAllSprintCode() {
    return sprintRepository.findAllSprintCode();
  }

  public List<Sprint> getAllSprint() {
    return sprintRepository.findAll();
  }
}

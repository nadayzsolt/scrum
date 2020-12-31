package com.scrumpoker.scrumpoker.services;

import com.scrumpoker.scrumpoker.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
  private final PartyRepository partyRepository;

  @Autowired
  public PartyService(PartyRepository partyRepository) {
    this.partyRepository = partyRepository;
  }
}

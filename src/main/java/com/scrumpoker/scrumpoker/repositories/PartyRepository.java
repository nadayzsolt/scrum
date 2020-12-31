package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.Party;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
  List<Party> findAll();
}

package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.Sprint;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
  List<Sprint> findAll();

  @Query (nativeQuery = true, value = "SELECT sprint_code FROM sprints")
  List<String> findAllSprintCode();

  @Query (nativeQuery = true, value = "SELECT * FROM sprints WHERE sprint_code = :sprintCode")
  Sprint findBySprintCode(String sprintCode);

  @Query (nativeQuery = true, value = "SELECT * FROM sprints WHERE random_event_nr = :randomEventNr")
  Sprint findByRandomEventNr(int randomEventNr);
}

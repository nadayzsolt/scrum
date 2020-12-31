package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.Sprint;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
  List<Sprint> findAll();
}

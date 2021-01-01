package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.Sprint;
import com.scrumpoker.scrumpoker.models.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findAll();

  List<Task> findAllBySprint(Sprint sprint);
}

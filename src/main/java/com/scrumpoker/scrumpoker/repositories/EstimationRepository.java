package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.Estimation;
import com.scrumpoker.scrumpoker.models.Task;
import com.scrumpoker.scrumpoker.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimationRepository extends JpaRepository<Estimation, Long> {
  List<Estimation> findAll();

  List<Estimation> findAllByUser(User user);

  boolean existsByUser(User user);

  boolean existsByTask(Task task);

  List<Estimation> findAllByTask(Task task);

  @Query (nativeQuery = true, value = "SELECT AVG(amount) FROM estimations WHERE task_id = :taskId")
  Integer findAvgAmountByTask(long taskId);
}

package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.Estimation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Estimation, Long> {
  List<Estimation> findAll();
}

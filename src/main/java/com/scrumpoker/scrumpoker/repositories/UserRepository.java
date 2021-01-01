package com.scrumpoker.scrumpoker.repositories;

import com.scrumpoker.scrumpoker.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findAll();

  boolean existsByName(String name);

  User findByName(String name);
}

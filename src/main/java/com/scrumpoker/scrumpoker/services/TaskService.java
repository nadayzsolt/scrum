package com.scrumpoker.scrumpoker.services;

import com.scrumpoker.scrumpoker.repositories.BidRepository;
import com.scrumpoker.scrumpoker.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
  private final TaskRepository taskRepository;
  private final BidRepository bidRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository,
                     BidRepository bidRepository) {
    this.taskRepository = taskRepository;
    this.bidRepository = bidRepository;
  }
}

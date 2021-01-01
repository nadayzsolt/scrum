package com.scrumpoker.scrumpoker.services;

import com.scrumpoker.scrumpoker.models.Estimation;
import com.scrumpoker.scrumpoker.models.Task;
import com.scrumpoker.scrumpoker.models.User;
import com.scrumpoker.scrumpoker.repositories.EstimationRepository;
import com.scrumpoker.scrumpoker.repositories.TaskRepository;
import com.scrumpoker.scrumpoker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final EstimationRepository estimationRepository;
  private final TaskRepository taskRepository;

  @Autowired
  public UserService(UserRepository userRepository,
                     EstimationRepository estimationRepository,
                     TaskRepository taskRepository) {
    this.userRepository = userRepository;
    this.estimationRepository = estimationRepository;
    this.taskRepository = taskRepository;
  }

  public void saveEstimation(int amount, long userId, long taskId) {
    User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);
    Task task = taskRepository.findById(taskId).orElseThrow(NullPointerException::new);
    if (estimationRepository.existsByUser(user) && estimationRepository.existsByTask(task)){
    } else {
      estimationRepository.save(new Estimation(amount,
          userRepository.findById(userId).orElseThrow(NullPointerException::new),
          taskRepository.findById(taskId).orElseThrow(NullPointerException::new)));
    }
  }

  public User loginOrRegister(String name) {
    User user;
    if (!userRepository.existsByName(name)){
      user = new User(name);
      userRepository.save(user);
    } else {
      user = userRepository.findByName(name);
    }
    return user;
  }
}
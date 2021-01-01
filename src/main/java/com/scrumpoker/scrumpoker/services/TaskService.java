package com.scrumpoker.scrumpoker.services;

import com.scrumpoker.scrumpoker.models.Estimation;
import com.scrumpoker.scrumpoker.models.Sprint;
import com.scrumpoker.scrumpoker.models.Task;
import com.scrumpoker.scrumpoker.models.User;
import com.scrumpoker.scrumpoker.repositories.EstimationRepository;
import com.scrumpoker.scrumpoker.repositories.SprintRepository;
import com.scrumpoker.scrumpoker.repositories.TaskRepository;
import com.scrumpoker.scrumpoker.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
  private final TaskRepository taskRepository;
  private final EstimationRepository estimationRepository;
  private final SprintRepository sprintRepository;
  private final UserRepository userRepository;

  @Autowired
  public TaskService(TaskRepository taskRepository,
                     EstimationRepository estimationRepository,
                     SprintRepository sprintRepository,
                     UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.estimationRepository = estimationRepository;
    this.sprintRepository = sprintRepository;
    this.userRepository = userRepository;
  }

  public void addTask(String taskCode, String taskDescription, String sprintCode) {
    Sprint sprint = sprintRepository.findBySprintCode(sprintCode);
    taskRepository.save(new Task(taskCode, taskDescription, sprint));
  }

  public List<Task> getAllTasksByRandomEventNr(int randomEventNr) {
    Sprint sprint = sprintRepository.findByRandomEventNr(randomEventNr);
    return taskRepository.findAllBySprint(sprint);
  }

  public List<Estimation> getAllEstimationsByUser(long userId) {
    User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);
    return estimationRepository.findAllByUser(user);
  }

  public List<Estimation> getAllEstimationsByTask(long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(NullPointerException::new);
    return estimationRepository.findAllByTask(task);
  }

  public int getAvgEstimationByTask(long taskId) {
    try {
      return (int) estimationRepository.findAvgAmountByTask(taskId);
    } catch (NullPointerException e) {
      return 0;
    }
  }

  public Task getTaskById(long taskId) {
    return taskRepository.findById(taskId).orElseThrow(NullPointerException::new);
  }

  public void setAvgEstimationByTaskId(long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(NullPointerException::new);
    task.setAvgEstimation(getAvgEstimationByTask(taskId));
  }

  public void setAlternativeAvgEstimationByTaskId(long taskId, int amount) {
    Task task = taskRepository.findById(taskId).orElseThrow(NullPointerException::new);
    task.setAvgEstimation(getAvgEstimationByTask(taskId));
  }
}
package com.scrumpoker.scrumpoker.controllers;

import com.scrumpoker.scrumpoker.services.SprintService;
import com.scrumpoker.scrumpoker.services.TaskService;
import com.scrumpoker.scrumpoker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
  private final UserService userService;
  private final TaskService taskService;
  private final SprintService sprintService;

  @Autowired
  public UserController(UserService userService,
                        TaskService taskService,
                        SprintService sprintService) {
    this.userService = userService;
    this.taskService = taskService;
    this.sprintService = sprintService;
  }
}

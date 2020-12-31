package com.scrumpoker.scrumpoker.controllers;

import com.scrumpoker.scrumpoker.services.SprintService;
import com.scrumpoker.scrumpoker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
  SprintService sprintService;
  TaskService taskService;

  @Autowired
  public AdminController(SprintService sprintService,
                         TaskService taskService) {
    this.sprintService = sprintService;
    this.taskService = taskService;
  }
}

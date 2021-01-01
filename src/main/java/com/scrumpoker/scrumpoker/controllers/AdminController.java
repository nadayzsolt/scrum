package com.scrumpoker.scrumpoker.controllers;

import com.scrumpoker.scrumpoker.models.User;
import com.scrumpoker.scrumpoker.services.SprintService;
import com.scrumpoker.scrumpoker.services.TaskService;
import com.scrumpoker.scrumpoker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
  SprintService sprintService;
  TaskService taskService;
  UserService userService;

  @Autowired
  public AdminController(SprintService sprintService,
                         TaskService taskService,
                         UserService userService) {
    this.sprintService = sprintService;
    this.taskService = taskService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String renderSprintCreatingPage (){
    return "index";
  }

  @PostMapping ("/sprintCreate")
  public String setSprint(String sprintCode){
    sprintService.addSprint(sprintCode);
    return "redirect:/";
  }

  @GetMapping("/tasks")
  public String renderTaskCreatingPage (Model model){
    model.addAttribute("sprints", sprintService.getAllSprint());
    return "tasks";
  }

  @PostMapping ("/taskCreate")
  public String setTask(String sprintCode, String taskCode, String taskDescription){
    taskService.addTask(taskCode, taskDescription, sprintCode);
    return "redirect:/tasks";
  }

  @GetMapping("/invite/{randomEventNr}")
  public String renderInvitePage(@PathVariable int randomEventNr, Model model){
    model.addAttribute("randomEventNr", randomEventNr);
    return "invite";
  }

  @GetMapping ("/host/{randomEventNr}")
  public String renderHostTaskTable(@PathVariable int randomEventNr, Model model){
    model.addAttribute("tasks", taskService.getAllTasksByRandomEventNr(randomEventNr));
    model.addAttribute("randomeventnr", randomEventNr);
    return "hosttasktable";
  }

  @GetMapping ("/join/{randomEventNr}")
  public String renderLogin(@PathVariable int randomEventNr, Model model){
    model.addAttribute("randomeventnr", randomEventNr);
    return "login";
  }

  @PostMapping("/registry/{randomEventNr}")
  public String loginUser(@PathVariable int randomEventNr, String name){
    User user = userService.loginOrRegister(name);
    return "redirect:/join/" + randomEventNr + "/" + user.getId();
  }

  @GetMapping ("/join/{randomEventNr}/{userId}")
  public String renderJoinTaskTable(@PathVariable int randomEventNr, @PathVariable long userId, Model model){
    model.addAttribute("tasks", taskService.getAllTasksByRandomEventNr(randomEventNr));
    model.addAttribute("randomeventnr", randomEventNr);
    model.addAttribute("userid", userId);
//    model.addAttribute("estimationList", taskService.getAllEstimationsByUser(userId));
    return "jointasktable";
  }

  @PostMapping("/input/{randomEventNr}/{userId}")
  public String renderTaskEstimationInput(@PathVariable String randomEventNr, @PathVariable long userId, long taskId, int amount){
    userService.saveEstimation(amount, userId, taskId);
    return "redirect:/join/" + randomEventNr + "/" + userId;
  }

 @GetMapping ("/host/{randomEventNr}/{taskId}")
 public String renderTaskEstimationOverview(@PathVariable int randomEventNr, @PathVariable long taskId, Model model){
    model.addAttribute("task", taskService.getTaskById(taskId));
    model.addAttribute("taskestimations", taskService.getAllEstimationsByTask(taskId));
    model.addAttribute("avgEstimation", taskService.getAvgEstimationByTask(taskId));
    model.addAttribute("randomeventnr", randomEventNr);
    return "taskoverview";
 }

 @PostMapping ("/alternativeavg/{randomEventNr}")
  public String setAlternativeAvgEstimation(@PathVariable int randomEventNr, long taskId, int amount){
    taskService.setAlternativeAvgEstimationByTaskId(taskId, amount);
    return "redirect:/host/" + randomEventNr;
 }
}
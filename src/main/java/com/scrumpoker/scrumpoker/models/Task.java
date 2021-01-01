package com.scrumpoker.scrumpoker.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "tasks")
public class Task {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;
  private String taskCode;
  private String taskDescription;
  private double avgEstimation;
  @ManyToOne
  private Sprint sprint;
  @OneToMany (mappedBy = "task")
  private List<Estimation> estimationList;
  @ManyToMany (mappedBy = "taskList")
  private List<User> userList;

  public Task(String taskCode, String taskDescription, Sprint sprint) {
    this.taskCode = taskCode;
    this.taskDescription = taskDescription;
    this.sprint = sprint;
  }
}
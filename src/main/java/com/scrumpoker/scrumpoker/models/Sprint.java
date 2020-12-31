package com.scrumpoker.scrumpoker.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table (name = "sprints")
public class Sprint {
  @Id
  @GeneratedValue
  private long id;
  private int randomEventNr;
  private String sprintCode;
  @ManyToMany (mappedBy = "sprintList")
  private List<User> userList;
  @OneToMany (mappedBy = "sprint")
  private List<Task> taskList;

  public Sprint(String sprintCode) {
    this.sprintCode = sprintCode;
    this.randomEventNr = (int)(Math.random() * 900000) + 100000;;
  }
}
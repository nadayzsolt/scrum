package com.scrumpoker.scrumpoker.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table (name = "users")
public class User {
  @Id
  @GeneratedValue
  private long id;
  private String userName;
  @OneToMany (mappedBy = "user")
  private List<Estimation> estimationList;
  @ManyToMany
  private List<Sprint> sprintList;
  @ManyToMany
  private List<Task> taskList;

  public User(String userName) {
    this.userName = userName;
  }
}

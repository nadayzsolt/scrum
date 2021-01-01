package com.scrumpoker.scrumpoker.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  @OneToMany (mappedBy = "user")
  private List<Estimation> estimationList;
  @ManyToMany
  private List<Sprint> sprintList;
  @ManyToMany
  private List<Task> taskList;

  public User(String name) {
    this.name = name;
  }
}

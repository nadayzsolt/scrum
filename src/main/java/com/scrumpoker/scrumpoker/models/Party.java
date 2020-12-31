package com.scrumpoker.scrumpoker.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Party {
  @Id
  @GeneratedValue
  private long id;
  private String sprintName;
  @OneToMany
  private List<User> userList;
  @OneToMany
  private List<Game> gameList;
}

package com.scrumpoker.scrumpoker.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

  @Id
  @GeneratedValue
  @Column
  private long id;

  private String userName;
  @OneToMany
  private List<Game> gameList;


}

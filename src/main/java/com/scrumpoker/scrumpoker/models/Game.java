package com.scrumpoker.scrumpoker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Game {
  @Id
  @GeneratedValue
  private long id;
  private String taskCode;
  private String taskDescription;
}

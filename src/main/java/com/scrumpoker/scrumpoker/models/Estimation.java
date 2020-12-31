package com.scrumpoker.scrumpoker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table (name = "estimations")
public class Estimation {
  @Id
  @GeneratedValue
  private long id;
  private int amount;
  @ManyToOne
  private User user;
  @ManyToOne
  private Task task;

  public Estimation(int amount, User user) {
    this.amount = amount;
    this.user = user;
  }
}

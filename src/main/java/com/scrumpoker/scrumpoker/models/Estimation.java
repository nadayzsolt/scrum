package com.scrumpoker.scrumpoker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table (name = "estimations")
public class Estimation {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private long id;
  private Integer amount;
  @ManyToOne
  private User user;
  @ManyToOne
  private Task task;

  public Estimation(Integer amount, User user, Task task) {
    this.amount = amount;
    this.user = user;
    this.task = task;
  }
}

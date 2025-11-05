package com.example.demo.Bees;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Bees")
public class Bee {
    public class Bees {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long BeeId;

  @Column(nullable = false)
  private String name;

  

  @Column(nullable = false)
  private String description;

  public Bees() {
  }

  public Bees(Long BeeId, String name, String description) {
    this.BeeId = BeeId;
    this.name = name;
    this.description = description;
  }

  public Bees(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Long getBeeId() {
    return BeeId;
  }

  public void setBeeId(Long id) {
    this.BeeId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
}


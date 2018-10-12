package com.linkedin.learning.reactivespring.model;


import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Purchase {

  private final String name;
  private final String price;
  private final LocalDateTime createdAt;

  @Id
  private String id;


  public Purchase(String name, String price, LocalDateTime createdAt) {
    this.name = name;
    this.price = price;
    this.createdAt = createdAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getPrice() {
    return price;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
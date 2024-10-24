package com.hazinlab.gestortareasbackend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class User {

  @Id
  private String id;

  private String name;
  private String pwd;

  public User() {}

  public User(String name, String pwd) {
    this.name = name;
    this.pwd = pwd;
  }
}

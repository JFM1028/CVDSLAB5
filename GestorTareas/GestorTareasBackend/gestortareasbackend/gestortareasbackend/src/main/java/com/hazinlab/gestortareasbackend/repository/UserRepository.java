package com.hazinlab.gestortareasbackend.repository;

import com.hazinlab.gestortareasbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  User findByNameAndPwd(String name, String pwd);
}

package com.hazinlab.gestortareasbackend.repository;

import com.hazinlab.gestortareasbackend.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByNameAndPwd(String name, String pwd);
}

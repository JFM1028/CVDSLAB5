package com.hazinlab.gestortareasbackend.service;

import com.hazinlab.gestortareasbackend.model.User;
import com.hazinlab.gestortareasbackend.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userrepo;

  public User findUser(String id) {
    return userrepo.findById(id).get();
  }

  /**
   * Agrega un nuevo usuario a la base de datos.
   *
   * @param user El usuario a agregar.
   */
  public User addUser(User user) {
    return userrepo.save(user);
  }

  public List<User> findAll() {
    return userrepo.findAll();
  }

  public Optional<User> findByNameAndPwd(String name, String pwd) {
    return userrepo.findByNameAndPwd(name, pwd);
  }
}

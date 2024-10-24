package com.hazinlab.gestortareasbackend.controller;

import com.hazinlab.gestortareasbackend.model.User;
import com.hazinlab.gestortareasbackend.model.UserDTO;
import com.hazinlab.gestortareasbackend.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public List<User> obtenerUsuarios() {
    return userService.findAll();
  }

  @GetMapping("/{userId}")
  public User obtenerUsuario(@PathVariable String userId) {
    return userService.findUser(userId);
  }

  @PostMapping("/")
  public User createUser(@RequestBody UserDTO userdto) {
    User user = new User(userdto.getName(), userdto.getPwd());
    return userService.addUser(user);
  }

  @GetMapping("/verification")
  public User verificateLogin(@RequestBody UserDTO userdto) {
    User user = new User(userdto.getName(), userdto.getPwd());
    return userService.findUserByNameAndPass(user);
  }
}

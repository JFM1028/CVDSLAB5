package com.hazinlab.gestortareasbackend.controller;

import java.util.List;

import com.hazinlab.gestortareasbackend.model.Tarea;
import com.hazinlab.gestortareasbackend.model.TareaDTO;
import com.hazinlab.gestortareasbackend.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hazinlab.gestortareasbackend.model.User;
import com.hazinlab.gestortareasbackend.service.UserService;

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

    @PostMapping("/{idUser}/addTask")
    public User addTask(@PathVariable  String idUser,  @RequestBody  TareaDTO tareaDTO) {
        return userService.addTask(idUser, tareaDTO);
    }

    @PostMapping("/")
    public User createUser(@RequestBody UserDTO userdto){
        User user = new User(userdto.getName(), userdto.getPwd());
        return userService.addUser(user);
    }

    @GetMapping("/verification")
    public User verificateLogin(@RequestBody UserDTO userdto){
        User user = new User(userdto.getName(), userdto.getPwd());
        return userService.findUserByNameAndPass(user);
    }
}

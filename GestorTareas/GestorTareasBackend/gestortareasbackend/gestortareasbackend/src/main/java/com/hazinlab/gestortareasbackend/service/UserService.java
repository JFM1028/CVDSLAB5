package com.hazinlab.gestortareasbackend.service;

import com.hazinlab.gestortareasbackend.model.Tarea;
import com.hazinlab.gestortareasbackend.model.TareaDTO;
import com.hazinlab.gestortareasbackend.model.User;
import com.hazinlab.gestortareasbackend.repository.UserRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

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


    public User addTask(String userID, TareaDTO tareaDTO) {
        return userrepo.addTask(userID, tareaDTO);
    }

    public List<User> findAll() {
        return userrepo.findAll();
    }

    public User findUserByNameAndPass(User user) {
        User user1 = userrepo.findByNameAndPwd(user.getName(), user.getPwd());
        if(user1 != null){
            return user;
        }
        /*se arroja exception en los casos en los que el user no existe*/
        throw new RuntimeException("Usuario no encontrado");
    }
}

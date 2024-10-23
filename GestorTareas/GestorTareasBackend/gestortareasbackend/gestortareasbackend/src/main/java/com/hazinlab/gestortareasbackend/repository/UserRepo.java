package com.hazinlab.gestortareasbackend.repository;

import com.hazinlab.gestortareasbackend.model.Tarea;
import com.hazinlab.gestortareasbackend.model.TareaDTO;
import com.hazinlab.gestortareasbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {

    default User addTask(String userId, TareaDTO tareaDTO) {
        Optional<User> user = findById(userId);
        if (user.isPresent()) {
            User actualUser = user.get();
            Tarea tarea = new Tarea(tareaDTO); // Asegúrate de tener un constructor adecuado en Tarea
            actualUser.addTask(tarea);
            return this.save(actualUser); // Guarda el usuario después de agregar la tarea
        }
        return null;
    }

    User findByNameAndPwd(String name, String pwd);
}

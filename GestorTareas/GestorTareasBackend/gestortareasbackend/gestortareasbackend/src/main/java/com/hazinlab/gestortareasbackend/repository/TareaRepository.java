package com.hazinlab.gestortareasbackend.repository;

import com.hazinlab.gestortareasbackend.model.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Interfaz que define el repositorio para la entidad Tarea.
 * Esta interfaz hereda de MongoRepository, lo que proporciona métodos
 * CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad Tarea.
 */
public interface TareaRepository extends MongoRepository<Tarea, String> {
    List<Tarea> findByUsuarioId(String usuarioId);
}
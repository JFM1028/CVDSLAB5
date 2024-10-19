package com.hazinlab.gestortareasbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.NoSuchElementException;
import java.util.List;

import com.hazinlab.gestortareasbackend.model.Tarea;
import com.hazinlab.gestortareasbackend.model.TareaDTO;
import com.hazinlab.gestortareasbackend.service.TareaService;

/**
 * Controlador REST para manejar operaciones relacionadas con las tareas.
 * Proporciona endpoints para obtener, agregar, completar y eliminar tareas.
 */
@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    /**
     * Obtiene la lista de todas las tareas.
     *
     * @return una lista de objetos Tarea.
     */
    @GetMapping("/usuario/{usuarioId}")
    public List<Tarea> obtenerTareas(@PathVariable String usuarioId) {
        return tareaService.obtenerTareas(usuarioId);
    }

    /**
     * Agrega una nueva tarea.
     *
     * @param tarea el objeto Tarea que se va a agregar.
     * @return el objeto Tarea agregado.
     */
    @PostMapping
    public Tarea agregarTarea(@RequestBody Tarea tarea) {
        return tareaService.agregarTarea(tarea);
    }

    @PutMapping("/{id}/actualizar")
    public Tarea actualizarTarea(
            @PathVariable String id,
            @RequestBody TareaDTO tareaDTO
    ) {
        return tareaService.actualizarTarea(
                id,
                tareaDTO.getNombre(),
                tareaDTO.getDescripcion(),
                tareaDTO.getDificultad(),
                tareaDTO.getPrioridad()
        );
    }

    /**
     * Marca una tarea como completada.
     *
     * @param id el ID de la tarea que se va a marcar como completada.
     * @return el objeto Tarea actualizado.
     */
    @PutMapping("/{id}/completar")
    public Tarea marcarCompletada(@PathVariable String id) {
        return tareaService.marcarCompletada(id);
    }

    /**
     * Elimina una tarea por su ID.
     *
     * @param id el ID de la tarea que se va a eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable String id) {
        tareaService.eliminarTarea(id);
    }

}

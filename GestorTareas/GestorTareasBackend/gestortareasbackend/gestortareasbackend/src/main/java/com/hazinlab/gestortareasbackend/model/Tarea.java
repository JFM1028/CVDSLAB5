package com.hazinlab.gestortareasbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Representa una tarea en el sistema.
 * La clase Tarea se utiliza para almacenar la información de una tarea,
 * incluyendo su descripción, estado de completada y un identificador único.
 */
@Document(collection = "tareas")
public class Tarea {

    @Id
    private String id;

    private String nombre;
    private String descripcion;
    private boolean completada;
    private String dificultad;
    private int prioridad;
    private String fecha;
    private String fechaFinalizacion;

    /**
     * Constructor vacío (necesario para deserialización).
     */
    public Tarea() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param descripcion la descripción de la tarea.
     * @param completada  el estado de la tarea (completada o no).
     */
    public Tarea(String nombre, String descripcion, boolean completada, String dificultad, int prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = completada;
        this.dificultad = dificultad;
        this.prioridad = prioridad;
        this.fecha = new Date().toString();
    }

    public void actualizarTarea(String nombre, String descripcion, String nuevaDificultad, int prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        definirDificultad(nuevaDificultad);
        this.prioridad = prioridad;
    }

    private void definirDificultad(String nuevaDificultad) {
        this.dificultad = nuevaDificultad;
    }

    /**
     * Marca la tarea como completada y establece la fecha de finalización.
     *
     * @param completada el estado de la tarea.
     */
    public  void setCompletada(boolean completada) {
        this.completada = completada;
        if (completada) {
            // Establece la fecha de finalización en la fecha actual.
            this.fechaFinalizacion = new Date().toString();
        }
    }


}

package com.hazinlab.gestortareasbackend.model;

import jakarta.annotation.PostConstruct;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
  private String usuarioId;

  /**
   * Constructor vacío (necesario para deserialización).
   */
  public Tarea() {}

  /**
   * Constructor con parámetros.
   *
   * @param descripcion la descripción de la tarea.
   * @param completada  el estado de la tarea (completada o no).
   * @param dificultad  la dificultad de la tarea.
   * @param prioridad   la prioridad de la tarea.
   * @param usuarioId   el ID del usuario al que pertenece la tarea.
   * @param nombre      el nombre de la tarea.
   */
  public Tarea(
    String nombre,
    String descripcion,
    boolean completada,
    String dificultad,
    int prioridad,
    String usuarioId
  ) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.completada = completada;
    this.dificultad = dificultad;
    this.prioridad = prioridad;
    this.fecha = new Date().toString();
    this.usuarioId = usuarioId;
  }

  /**
   * Actualiza los datos de la tarea.
   *
   * @param nombre         el nuevo nombre de la tarea.
   * @param descripcion    la nueva descripción de la tarea.
   * @param nuevaDificultad la nueva dificultad de la tarea.
   * @param prioridad      la nueva prioridad de la tarea.
   */
  public void actualizarTarea(
    String nombre,
    String descripcion,
    String nuevaDificultad,
    int prioridad
  ) {
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
  public void setCompletada(boolean completada) {
    this.completada = completada;
    if (completada) {
      // Establece la fecha de finalización en la fecha actual.
      this.fechaFinalizacion = new Date().toString();
    }
  }

  /**
   * Inicializa la fecha de creación de la tarea.
   */

  @PostConstruct
  public void init() {
    this.fecha = new Date().toString();
  }
}

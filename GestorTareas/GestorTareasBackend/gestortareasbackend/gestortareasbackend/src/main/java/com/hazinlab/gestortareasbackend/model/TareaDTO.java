package com.hazinlab.gestortareasbackend.model;


/**
 * La clase TareaDTO representa un objeto de transferencia de datos (DTO) que
 * se utiliza para manejar la información sobre una tarea en la aplicación.
 * Se creó para facilitar la comunicación entre la capa de presentación y la
 * capa de servicio, permitiendo que los datos sean transferidos de manera
 * estructurada y simplificada.
 *
 * Este DTO encapsula los atributos esenciales de una tarea, que son el
 * nombre y la descripción, asegurando que se envíen y reciban de manera
 * consistente en las solicitudes y respuestas de la API.
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaDTO {

  private String nombre; // Nombre de la tarea
  private String descripcion; // Descripción de la tarea
  private String dificultad;
  private int prioridad;

}

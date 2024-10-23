package com.hazinlab.gestortareasbackend.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserDTO {
    private String id ;
    private String name;
    private String pwd;
    private ArrayList<Tarea> tasks;
}

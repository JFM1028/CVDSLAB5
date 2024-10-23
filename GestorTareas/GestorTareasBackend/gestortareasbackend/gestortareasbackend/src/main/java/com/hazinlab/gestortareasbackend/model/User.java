package com.hazinlab.gestortareasbackend.model;

import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.TreeMap;

@Getter
@Setter

@Document(collection = "users")
public class User {
    @Id
    private String id ;
    private String name;
    private String pwd;
    private ArrayList<Tarea> tasks;

    public User(String name, String pwd) {
        this.tasks = new ArrayList<>();
        this.name = name;
        this.pwd = pwd;
    }

    public void addtask(Tarea task){
        tasks.add(task);
    }

    public void addTask(Tarea tarea) {
        tasks.add(tarea);
    }
}

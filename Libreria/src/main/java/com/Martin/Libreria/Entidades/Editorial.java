
package com.Martin.Libreria.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Editorial {
    
    //atributos
    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid" , strategy="uuid2")
    private String id;
    private String nombre;
    private Boolean alta;
    
    //constructor
    public Editorial(String id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }
    
    //constructor vacio
    public Editorial() {
    }
    
    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", alta=" + alta + '}';
    }
    
    
    
    
}

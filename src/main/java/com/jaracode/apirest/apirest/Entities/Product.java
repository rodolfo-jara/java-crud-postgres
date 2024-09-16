package com.jaracode.apirest.apirest.Entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  nombre;
    private String description;
    private double precio;
    private String image;




    //constructor bacio
    public Product() {
    }
    //contructores


    
    public Long getId() {
        return id;
    }
    public Product(Long id, String nombre, String description, double precio, String image) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.precio = precio;
        this.image = image;
    }



    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }



}

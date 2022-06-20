package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notebooks")

public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull()
    private String marca;

    @NotNull()
    private String modelo;

    @NotNull()
    private Integer puertosUSB;

    @NotNull()
    private String color;

    public Notebook() {
    }

    public Notebook(Long id, @NotNull String marca, @NotNull String modelo, @NotNull Integer puertosUSB,
            @NotNull String color) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.puertosUSB = puertosUSB;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPuertosUSB() {
        return puertosUSB;
    }

    public void setPuertosUSB(Integer puertosUSB) {
        this.puertosUSB = puertosUSB;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
package com.mycompany.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class Alumno implements UnionDeMetodos {
    private String nombre;
    private String legajo;
    
    protected List<Materia> materiasAprobadas = new ArrayList<>();  
    protected List<Materia> materiasDesaprobadas = new ArrayList<>();

    public Alumno(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    @Override
    public boolean puedeCursar(boolean aprobada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aprobada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

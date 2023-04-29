package com.mycompany.tpintegrador;

import java.util.ArrayList;
import java.util.List;

public class Materia implements UnionDeMetodos {
    private String nombre;
    private String nombreAlumno;
    protected List<Materia> correlativas = new ArrayList<>();

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean puedeCursar(boolean aprobada) {
        if (aprobada == true) {
            System.out.println("Tiene la materia aprobada " + nombre + " puede cursar.");
        } else if (aprobada == false) {
            System.out.println("No puede cursar porque la materia " + nombre + " no esta aprobada.");
        }
        return aprobada;
    }

    @Override
    public void aprobada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

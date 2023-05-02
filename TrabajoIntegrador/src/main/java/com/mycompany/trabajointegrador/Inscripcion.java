package com.mycompany.trabajointegrador;

import java.util.Date;

public class Inscripcion {
    Materia materia;
    Alumno alumno;
    Date fecha = new Date();
    boolean aprobada;

    public Inscripcion(Materia materia, Alumno alumno) {
        this.materia = materia;
        this.alumno = alumno;
    }
    
    public boolean getAprobada() {
        return aprobada;
    }
    
    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inscripcion - " + "Materias: " + materia + "\n" + alumno + "\nFecha de creacion: " + fecha;
    }

    //Método de que tiene aprobada la materia
    public void aprobada() {
        System.out.println("----------------------");
        System.out.println("Creando inscripcion...");
        System.out.println("----------------------");

        System.out.println(toString());
    }
}

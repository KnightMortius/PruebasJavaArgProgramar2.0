package com.mycompany.trabajointegrador;

import java.util.Date;
import java.util.Scanner;

public class Inscripcion {
    private static Scanner entrada = new Scanner(System.in);

    Materia materia;
    Alumno alumno;
    Date fecha = new Date();

    public Inscripcion(Materia materia, Alumno alumno) {
        this.materia = materia;
        this.alumno = alumno;
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
        return "Inscripcion{" + "materia=" + materia + ", alumno=" + alumno + ", fecha=" + fecha + '}';
    }

    //Método de que tiene aprobada la materia
    public void aprobada() {
        //
    }
}

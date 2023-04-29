package com.mycompany.trabajointegrador;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Materia {

    private static Scanner entrada = new Scanner(System.in);

    public String nombre;
    public ArrayList<String> correlativas = new ArrayList<>();

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<String> correlativas) {
        this.correlativas = correlativas;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", correlativas=" + correlativas + '}';
    }

    //Método de si puede o no cursar un alumno
    public Alumno puedeCursar(boolean Alumno) {
        if (Alumno == true) {
            System.out.println("Puede cursar");
        } else {
            System.out.println("No puede cursar");
        }

        return null;
    }

}

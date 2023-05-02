package com.mycompany.trabajointegrador;
import java.util.ArrayList;

public class Materia {

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
        return nombre + ", correlativas: " + correlativas.toString().replace("]", "").replace("[", "");
    }

    //Método de si puede o no cursar un alumno
    public boolean puedeCursar(boolean entrada) {
        System.out.println("------------------------------------");
        System.out.println("Verificando materias correlativas...");
        System.out.println("------------------------------------");
        
        if (entrada) {
            System.out.println("-------------------------------------------------");
            System.out.println("Tiene la materia/as aprobadas. Puede inscribirse.");
            System.out.println("-------------------------------------------------");
        }
        
        return entrada;
    }

}

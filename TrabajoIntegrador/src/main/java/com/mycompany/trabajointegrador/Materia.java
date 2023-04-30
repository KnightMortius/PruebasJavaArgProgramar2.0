package com.mycompany.trabajointegrador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.sql.ResultSet;
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
    public Alumno puedeCursar(boolean Alumno) throws SQLException, JsonProcessingException, ClassNotFoundException {
        Conexion conexionDB = new Conexion();

        System.out.println(getCorrelativas());
        
        conexionDB.cerrarConexion();

        return null;
    }

}

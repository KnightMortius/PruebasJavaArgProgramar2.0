package com.mycompany.trabajointegrador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrabajoIntegradorMain {

    //Método para traer los datos de SQL
    private static void traerDatosSQL() throws SQLException, JsonProcessingException, ClassNotFoundException {
        Alumno alumnos = new Alumno();
        Materia materias = new Materia();
        Conexion conexionDB = new Conexion();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        HashMap<ArrayList<String>, ArrayList<String>> hmMaterias = new HashMap<>();
        HashMap<ArrayList<String>, ArrayList<String>> infoAlumnos = new HashMap<>();

        conexionDB.establecerConexion();

        Statement estado = conexionDB.conectar.createStatement();

        ResultSet aAlumnos = estado.executeQuery("SELECT * FROM alumnos");

        while (aAlumnos.next()) {
            alumnos.nombre = aAlumnos.getString("nombre");
            alumnos.legajo = aAlumnos.getInt("legajo");

            String materiasAprobadasString = objectMapper.writeValueAsString(aAlumnos.getString("materias_aprobadas"));

            ArrayList<String> listaMateriasAprobadas = objectMapper.readValue(materiasAprobadasString, ArrayList.class);

            ArrayList<String> nombreYLegajo = new ArrayList<>();
            nombreYLegajo.add("Nombre del Alumno: " + alumnos.nombre + ", N° de Legajo: " + alumnos.legajo);

            alumnos.setMateriasAprobadas(listaMateriasAprobadas);

            infoAlumnos.put(nombreYLegajo, alumnos.getMateriasAprobadas());

        }

        ResultSet mMaterias = estado.executeQuery("SELECT * FROM materias");

        while (mMaterias.next()) {
            materias.nombre = mMaterias.getString("nombre");

            String materiasString = objectMapper.writeValueAsString(mMaterias.getString("correlativas"));

            ArrayList<String> nombreCorrelativas = objectMapper.readValue(materiasString, ArrayList.class);

            materias.setCorrelativas(nombreCorrelativas);

            ArrayList<String> materiaNombre = new ArrayList<>();

            materiaNombre.add(materias.nombre);

            hmMaterias.put(materiaNombre, materias.getCorrelativas());

        }

        conexionDB.cerrarConexion();

        hmMaterias.entrySet().forEach(entry -> {
            String llave = entry.getKey().toString().replace("[", "").replace("]", "").replace("\"", "");
            String valor = entry.getValue().toString().replace("[", "").replace("]", "").replace("\"", "");

            System.out.println("Nombre de la materia: " + llave);
            System.out.println("Correlativas de la materia: " + valor);
        });

        infoAlumnos.entrySet().forEach(entry -> {
            String llave = entry.getKey().toString().replace("[", "").replace("]", "").replace("\"", "");
            String valor = entry.getValue().toString().replace("[", "").replace("]", "").replace("\"", "");

            System.out.println("Informacion del Alumno: " + llave);
            System.out.println("Materias aprobadas: " + valor);
        });
    }
    //------------------------------------------------------------------------------------------------

    //Método para verificar si el alumno puede o no inscribirse
    private static void verificacionInscripcion() {

    }
    //------------------------------------------------------------------------------------------------

    //Método para llamar al Menu Alumnos
    private static void menuAlumno() throws SQLException, ClassNotFoundException, JsonProcessingException {
        Scanner menuA = new Scanner(System.in);
        menuA.useDelimiter("\n");

        int cicloAlumno = 1;
        int seleccionAlumno = 0;

        do {
            do {
                System.out.println("-----------------------------");
                System.out.println("      ¿Que desea hacer?       ");
                System.out.println("-----------------------------");
                System.out.println("1 - Crear alumno.");
                System.out.println("2 - Eliminar alumno.");
                System.out.println("3 - Mostrar todos los alumnos");
                System.out.println("4 - Salir.");
                System.out.println("-----------------------------");
                seleccionAlumno = menuA.nextInt();

                if (seleccionAlumno >= 1 && seleccionAlumno <= 4) {
                    cicloAlumno = 1;
                } else {
                    System.out.println("------------------------------------------");
                    System.out.println("Opcion no disponible, vuelve a intentarlo.");
                    System.out.println("------------------------------------------");
                }

            } while (cicloAlumno == 0);

            switch (seleccionAlumno) {
                case 1 -> {
                    Conexion conexionDB = new Conexion();
                    Alumno alumnos = new Alumno();

                    System.out.println("Legajo del alumno: ");
                    int legajo = menuA.nextInt();
                    alumnos.setLegajo(legajo);

                    System.out.println("Nombre del alumno: ");
                    String nombre = menuA.next();
                    alumnos.setNombre(nombre);

                    System.out.println("Cuantas materias aprobadas desea ingresar: ");
                    int numero = menuA.nextInt();

                    System.out.println("Que materias aprobadas tiene?: ");
                    ArrayList<String> materiasAprobadas = new ArrayList<>();

                    String input;

                    for (int i = 0; i < numero; i++) {
                        input = menuA.next();
                        materiasAprobadas.add(input);
                    }

                    String materiasAprobadasJson = new Gson().toJson(materiasAprobadas);

                    System.out.println("--------------------------------------------------------------");
                    System.out.println("  Creando alumno \"" + nombre + "\" con legajo N°: " + legajo + "...");
                    System.out.println("--------------------------------------------------------------");

                    conexionDB.establecerConexion();
                    Statement llamarEstado = conexionDB.conectar.createStatement();
                    llamarEstado.executeUpdate("INSERT INTO alumnos (nombre, legajo, materias_aprobadas) VALUES (\"" + nombre + "\", + " + legajo + ", '" + materiasAprobadasJson + "');");
                    conexionDB.cerrarConexion();
                }
                case 2 -> {
                    Conexion conexionDB = new Conexion();

                    System.out.println("Nombre del alumno: ");
                    String nombre = menuA.next();

                    System.out.println("Legajo del alumno: ");
                    int legajo = menuA.nextInt();

                    System.out.println("---------------------------------------------------------------");
                    System.out.println("Eliminando alumno \"" + nombre + "\" con legajo N°: " + legajo + "...");
                    System.out.println("---------------------------------------------------------------");

                    conexionDB.establecerConexion();
                    Statement llamarEstado = conexionDB.conectar.createStatement();
                    llamarEstado.executeUpdate("DELETE FROM alumnos WHERE nombre = \"" + nombre + "\" AND legajo = " + legajo);
                    conexionDB.cerrarConexion();

                }
                case 3 -> {
                    Conexion conexionDB = new Conexion();

                    System.out.println("-------------------------------------------------------");
                    System.out.println(" Mostrando lista de alumnos y sus respectivos legajos: ");
                    System.out.println("-------------------------------------------------------");

                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

                    HashMap<ArrayList<String>, ArrayList<String>> infoAlumno = new HashMap<>();

                    conexionDB.establecerConexion();
                    Statement llamarEstado = conexionDB.conectar.createStatement();

                    ResultSet estadoAlumnos = llamarEstado.executeQuery("SELECT * FROM alumnos ORDER BY id");

                    while (estadoAlumnos.next()) {

                        String alumnoNombre = estadoAlumnos.getString("nombre").replace("\"", "").replace("\\", "");
                        int alumnoLegajo = estadoAlumnos.getInt("legajo");
                        String mAprobadasLista = objectMapper.writeValueAsString(estadoAlumnos.getString("materias_aprobadas"));

                        ArrayList<String> nombreYLegajo = new ArrayList<>();
                        nombreYLegajo.add("Nombre del Alumno: " + alumnoNombre + ", N° de Legajo: " + alumnoLegajo);

                        ArrayList<String> listaMateriasAprobadas = objectMapper.readValue(mAprobadasLista, ArrayList.class);

                        infoAlumno.put(nombreYLegajo, listaMateriasAprobadas);

                    }
                    conexionDB.cerrarConexion();

                    infoAlumno.entrySet().stream().map(entry -> {
                        System.out.println("Informacion del Alumno: " + entry.getKey().toString().replace("[", "").replace("]", ""));
                        return entry;
                    }).forEachOrdered(entry -> {
                        System.out.println("Materias aprobadas: " + entry.getValue().toString().replace("[", "").replace("]", "").replace("\"", ""));
                    });
                }
                case 4 -> {
                    System.out.println("--------------------------------------");
                    System.out.println("  Saliendo del menu sobre alumnos...  ");
                    System.out.println("--------------------------------------");
                    cicloAlumno = 2;
                }
                default -> {
                }
            }
        } while (cicloAlumno != 2);
    }
    //------------------------------------------------------------------------------------------------

    //Método para llamar al Menu Materias
    private static void menuMaterias() throws ClassNotFoundException, SQLException, JsonProcessingException {
        Scanner menuM = new Scanner(System.in);
        menuM.useDelimiter("\n");

        int cicloMateria = 1;
        int seleccionMateria = 0;

        do {
            do {
                System.out.println("------------------------------");
                System.out.println("      ¿Que desea hacer?       ");
                System.out.println("------------------------------");
                System.out.println("1 - Crear materia.");
                System.out.println("2 - Eliminar materias.");
                System.out.println("3 - Mostrar todas las materias");
                System.out.println("4 - Salir.");
                System.out.println("------------------------------");
                seleccionMateria = menuM.nextInt();

                if (seleccionMateria >= 1 && seleccionMateria <= 4) {
                    cicloMateria = 1;
                } else {
                    System.out.println("------------------------------------------");
                    System.out.println("Opcion no disponible, vuelve a intentarlo.");
                    System.out.println("------------------------------------------");
                }

            } while (cicloMateria == 0);

            switch (seleccionMateria) {
                case 1 -> {
                    Conexion conexionDB = new Conexion();
                    Materia materias = new Materia();

                    System.out.println("Que nombre quiere que tenga la materia?");
                    String nombre = menuM.next();
                    materias.setNombre(nombre);

                    System.out.println("Cuantas correlativas tiene?");
                    int numero = menuM.nextInt();

                    System.out.println("Que materias desea agregar a las correlativas?");
                    ArrayList<String> correlativas = new ArrayList<>();

                    String input;

                    for (int i = 0; i < numero; i++) {
                        input = menuM.next();
                        correlativas.add(input);
                    }

                    System.out.println("--------------------------------------------------------------------------------------------------------");

                    for (int i = 0; i < correlativas.size(); i++) {
                        System.out.println("         Añadiendo materia: " + nombre + "y sus respectivas correlativas " + correlativas.get(i) + "...");
                    }

                    System.out.println("--------------------------------------------------------------------------------------------------------");

                    String correlativasJson = new Gson().toJson(correlativas);

                    conexionDB.establecerConexion();
                    Statement llamarEstado = conexionDB.conectar.createStatement();
                    llamarEstado.executeUpdate("INSERT INTO materias (nombre, correlativas) VALUES(\"" + nombre + "\",'" + correlativasJson + "');");
                    conexionDB.cerrarConexion();

                }
                case 2 -> {
                    Conexion conexionDB = new Conexion();

                    System.out.println("Nombre de la materia: ");
                    String nombre = menuM.next();

                    System.out.println("-------------------------------------");
                    System.out.println("Eliminando materia: " + nombre + "...");
                    System.out.println("-------------------------------------");

                    conexionDB.establecerConexion();
                    Statement llamarEstado = conexionDB.conectar.createStatement();
                    llamarEstado.executeUpdate("DELETE FROM materias WHERE nombre = \"" + nombre + "\"");
                    conexionDB.cerrarConexion();

                }
                case 3 -> {
                    Conexion conexionDB = new Conexion();

                    System.out.println("-------------------------------------------------------------");
                    System.out.println(" Mostrando lista de materias y sus respectivas correlativas: ");
                    System.out.println("-------------------------------------------------------------");

                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

                    HashMap<String, String> hmMaterias = new HashMap<>();

                    conexionDB.establecerConexion();
                    Statement llamarEstado = conexionDB.conectar.createStatement();

                    ResultSet estadoMaterias = llamarEstado.executeQuery("SELECT * FROM materias ORDER BY id");

                    while (estadoMaterias.next()) {

                        String materiaNombre = estadoMaterias.getString("nombre");
                        String correlativasLista = objectMapper.writeValueAsString(estadoMaterias.getString("correlativas"));

                        hmMaterias.put(materiaNombre, correlativasLista);
                    }
                    conexionDB.cerrarConexion();

                    for (Map.Entry<String, String> entry : hmMaterias.entrySet()) {
                        String llave = entry.getKey().replaceAll("\\[\\]\"", "");
                        String valor = entry.getValue().replace("[", "").replace("]", "").replace("\"", "").replace("\\", "");

                        System.out.println("Nombre de la materia: " + llave);
                        System.out.println("Correlativas de la materia: " + valor);
                    }

                }
                case 4 -> {
                    System.out.println("------------------------------------");
                    System.out.println("  Saliendo del menu de materias...  ");
                    System.out.println("------------------------------------");
                    cicloMateria = 2;
                }
                default -> {
                }
            }
        } while (cicloMateria != 2);
    }
    //------------------------------------------------------------------------------------------------

    //Método para llamar al Menu
    private static void operacionMenu() throws ClassNotFoundException, SQLException, JsonProcessingException {
        Scanner entrada = new Scanner(System.in);

        int ciclo = 1;
        int seleccion = 0;

        do {
            do {
                System.out.println("--------------------------");
                System.out.println("    ¿Que desea hacer?     ");
                System.out.println("--------------------------");
                System.out.println("1 - Menu sobre alumnos.");
                System.out.println("2 - Menu sobre materias.");
                System.out.println("3 - Verificar inscriptos.");
                System.out.println("4 - Traer Datos SQL.");
                System.out.println("5 - Salir.");
                System.out.println("--------------------------");
                seleccion = entrada.nextInt();

                if (seleccion >= 1 && seleccion <= 5) {
                    ciclo = 1;
                } else {
                    System.out.println("------------------------------------------");
                    System.out.println("Opcion no disponible, vuelve a intentarlo.");
                    System.out.println("------------------------------------------");
                }

            } while (ciclo == 0);

            switch (seleccion) {
                case 1 -> {
                    menuAlumno();
                }
                case 2 -> {
                    menuMaterias();
                }
                case 3 -> {
                    verificacionInscripcion();
                }
                case 4 -> {
                    traerDatosSQL();
                }
                case 5 -> {
                    System.out.println("------------------------");
                    System.out.println("Gracias, vuelva pronto.");
                    System.out.println("------------------------");
                    ciclo = 2;
                }
                default -> {
                }
            }
        } while (ciclo != 2);
    }
    //------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonProcessingException {
        operacionMenu();
    }
}

package com.mycompany.tpintegrador;

public class TPIntegrador {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Jose Perez", "123CS");
        Alumno alumno2 = new Alumno("Luciano Dominguez", "643CV");
        Alumno alumno3 = new Alumno("Martina Gonzalez", "");
        Alumno alumno4 = new Alumno("Lautaro Costas", "412CM");

        Materia materia1 = new Materia("Programación I");
        Materia materia2 = new Materia("Programación II");
        Materia materia3 = new Materia("Base de Datos I");

        alumno1.materiasAprobadas.add(materia1);
        alumno2.materiasAprobadas.add(materia3);
        alumno4.materiasDesaprobadas.add(materia2);

        materia1.correlativas.add(materia1);
        
        Inscripcion nuevaInscripcion1 = new Inscripcion(alumno1, materia1);
       
        nuevaInscripcion1.aprobada();
    }
}

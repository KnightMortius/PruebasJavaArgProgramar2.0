package com.mycompany.tpintegrador;
import java.util.Date;
import java.util.Scanner;

public class Inscripcion implements UnionDeMetodos {
    protected static Scanner entrada = new Scanner(System.in);
    private Alumno nombre;
    private Materia materia;
    private Date fecha = new Date();  

    public Inscripcion(Alumno nombre, Materia materia) {
        this.nombre = nombre;
        this.materia = materia;
    }
    
    @Override
    public void aprobada() {
        if (materia.puedeCursar(true)) {
            System.out.println("Puede inscribirse.");
        } else if (materia.puedeCursar(false)) {
            System.out.println("No puede inscribirse.");
        }
    }

    @Override
    public boolean puedeCursar(boolean aprobada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

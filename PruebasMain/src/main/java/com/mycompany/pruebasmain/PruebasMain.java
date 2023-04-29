package com.mycompany.pruebasmain;

import java.sql.SQLException;

public class PruebasMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PruebasSecundarias timbre = new PruebasSecundarias();
/*        
        timbre.C1Consigna1A();
        
        System.out.println("");
        
        timbre.C1Consigna1B();
        
        System.out.println("");
        
        timbre.C1Consigna1C();
        
        System.out.println("");
        
        timbre.C1Consigna2A();

        System.out.println("");
        
        timbre.C3Consigna1A();
        
        System.out.println("");
        
        timbre.C3Consigna1B();

        System.out.println("");
        
        timbre.C3Consigna1C();

        System.out.println("");
        
        timbre.C3Consigna2A();
*/

        Conexion mensajero = new Conexion();
        
        mensajero.estableceConexion();
        
        mensajero.cerrarConnection();
        
        
    }
}

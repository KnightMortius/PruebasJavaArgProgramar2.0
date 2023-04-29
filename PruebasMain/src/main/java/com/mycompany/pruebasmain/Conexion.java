package com.mycompany.pruebasmain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conectar = null;

    String usuario = "root";
    String contraseña = "Lightning33!";
    String bd = "holamundo";
    String ip = "localhost";
    String puerto = "3306";

    String ruta = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conectar = DriverManager.getConnection(ruta, usuario, contraseña);

            System.out.println("Se conecto");

            //JOptionPane.showMessageDialog(null, "Se conecto correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO se conecto correctamente" + e);
        }

        return conectar;

    }

    public void cerrarConnection() throws SQLException {
        try {
            conectar.close();
            
            System.out.println("Se desconecto");
            
        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexion: " + e);
        }
    }
}

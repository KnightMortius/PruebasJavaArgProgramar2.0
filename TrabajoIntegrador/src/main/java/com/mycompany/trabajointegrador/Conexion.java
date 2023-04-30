package com.mycompany.trabajointegrador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conectar = null;

    String usuario = "root";
    String contraseña = "Lightning33!";
    String bd = "argprogramar";
    String ip = "localhost";
    String puerto = "3306";

    String ruta = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection establecerConexion() throws ClassNotFoundException {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conectar = DriverManager.getConnection(ruta, usuario, contraseña);
            
            //JOptionPane.showMessageDialog(null, "Se conecto correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO se conecto correctamente" + e);
        }

        return conectar;

    }

    public void cerrarConexion() throws SQLException {
        try {
            conectar.close();

        } catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexion: " + e);
        }
    }
}

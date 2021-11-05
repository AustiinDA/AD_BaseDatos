package Ejercicio_Biblioteca;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreacionBD {
    public static void crearDB() {
        String bd_nombre = "biblioteca";
        //Conexion
        Connection miCon = Conexion.conectar(bd_nombre);
        String consulta = "CREATE DATABASE IF NOT EXISTS " + bd_nombre;

        try {
            Statement CrearDB = miCon.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

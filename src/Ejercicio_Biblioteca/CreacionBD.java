package Ejercicio_Biblioteca;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreacionBD {
    public static void main(String[] args) {
        String bd_nombre = "biblioteca";
        //Conexion
        Connection miCon = Conexion.conectar(bd_nombre);
        String consulta = "CREATE DATABASE IF NOT EXISTS " + bd_nombre;

        try {
            Statement CrearDB = miCon.createStatement();
            CrearDB.execute(consulta);
            Statement CrearTabla = miCon.createStatement();
            CrearTabla.execute(Consultas.crearTablaLibro());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package Ejercicio_Biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreacionBD {
    public static void main(String[] args) {
        String bd_nombre = "Biblioteca";
        //Conexion
        Connection miCon = Conexion.conectar();



    }
}

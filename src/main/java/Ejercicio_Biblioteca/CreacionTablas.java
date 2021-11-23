package Ejercicio_Biblioteca;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreacionTablas {
    //Metodo de creacion de tablas
    public static void crearTabla(String nombre_tabla, String texto_consula) {
        String bd_nombre = "biblioteca";
        Connection miCon = Conexion.conectar();

        String consulta_tabla = "CREATE TABLE IF NOT EXISTS " + nombre_tabla + " " + texto_consula + ";";

        try {
            Statement CrearT = miCon.createStatement();
            CrearT.execute(consulta_tabla);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}


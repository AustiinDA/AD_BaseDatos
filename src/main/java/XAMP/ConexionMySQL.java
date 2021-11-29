package XAMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionMySQL {
    public static Connection conectar() {
        Connection conexion = null;
        final String USUARIO = "root";
        final String CONTRASEÑA = "";
        final String URL = "jdbc:mysql://localhost:3306/peliculas";

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conexion;
    }
}

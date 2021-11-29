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
        System.out.println("Esitó cra");

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);

            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM taquilla");

            while (rs.next()) {
                System.out.println("titulos: " + rs.getString("titulo"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conexion;
    }
}

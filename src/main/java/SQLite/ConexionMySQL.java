package SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionMySQL {
    public static void main(String[] args) {
        Connection connection = null;
        final String USUARIO = "root";
        final String CONTRASEÑA = "";
        final String URL = "jdbc:mysql://localhost:3306/peliculas";

        try {

            connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);

            System.out.println("Esitó cra");

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM taquilla");

            while (rs.next()) {
                System.out.println("titulos: " + rs.getString("titulo"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

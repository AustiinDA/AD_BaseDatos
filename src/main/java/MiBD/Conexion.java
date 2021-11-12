package MiBD;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/guachibase";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Exito");
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
        return conexion;
    }
}

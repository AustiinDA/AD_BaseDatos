import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/guachibase";
    private static final String USUARIO = "acx";
    private static final String CONTRASEÑA = "J_9UzdOE3P4rxg8m";

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

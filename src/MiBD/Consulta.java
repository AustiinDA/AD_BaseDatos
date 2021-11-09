package MiBD;

import java.sql.*;

public class Consulta {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection miCon = Conexion.conectar();
            PreparedStatement statement = miCon.prepareStatement("SELECT * FROM ciclistas");
            ResultSet results = statement.executeQuery();


            Statement s = miCon.createStatement();

            while (results.next()) {
                System.out.println("═══════════════════════════════════════════════");
                System.out.println("Nombre:" + results.getString("Nombre"));
                System.out.println("Equipo:" + results.getString("Equipo"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

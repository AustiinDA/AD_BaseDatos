package SQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionSQLite {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:chinook.db");
            System.out.println("Esitó cra");

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM albums");

            while (rs.next()){
                System.out.println("tulos: " +  rs.getString("title"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

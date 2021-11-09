package MiBD;

import java.sql.*;

public class CrearTabla {

    public static void main(String[] args) {
        Connection miCon = Conexion.conectar();

        //MiBD.Consulta reutilizable
        String crearTablica = "CREATE TABLE clientes (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR (32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))";
        try {
            Statement s = miCon.createStatement();
//            boolean consultaOK = s.execute(crearTablica);
//            if (consultaOK) {
//                System.out.println("MiBD.Consulta ejecutada con éxito");
//            }

            DatabaseMetaData dbmd = miCon.getMetaData();
            String driveVersion = dbmd.getDriverVersion();
            System.out.println(driveVersion);
            String[]tipos = {"TABLE"};

            ResultSet tables = dbmd.getTables(null, null, null,tipos);
            while (tables.next()){
                String catalogo = tables.getString("TABLE_CAT");
                String esquema = tables.getString("TABLE_SCHEM");
                String nombre = tables.getString("TABLE_NAME");
                String tipo = tables.getString("TABLE_TYPE");
                System.out.println("Catalogo:"+nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

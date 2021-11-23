package Ejercicio_Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

    public static void mostrarTablas() throws SQLException {
        Connection miCon = Conexion.conectar();

        ResultSet rs = miCon.getMetaData().getTables(null, null, null, null);
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
    }

    public static void mostrarContenidoLibros() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        System.out.println("\uD83D\uDCD6 LIBROS \uD83D\uDCD6");
        try {
            consulta = miCon.prepareStatement("SELECT * FROM Libros");
            //consultaLibros = miCon.prepareStatement("")
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                System.out.println(" Id:" + rs.getInt("codigo") + " TITULO: " + rs.getString("titulo")
                        + ", Editorial: " + rs.getString("editorial")
                        + ", ISBN: " + rs.getString("ISBN")
                        + ", Año: " + rs.getString("Año")
                        + ", Nº Ejemplares: " + rs.getInt("numEjemplares")
                        + ", Nº Páginas: " + rs.getInt("numPaginas")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarContenidoSocios() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        System.out.println("\uD83D\uDC65 SOCIOS \uD83D\uDC65");
        try {
            consulta = miCon.prepareStatement("SELECT * FROM Socios");

            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                System.out.println(" Id:" + rs.getInt("codigo")
                        + " Nombre: " + rs.getString("nombre")
                        + ", Apellidos: " + rs.getString("apellidos")
                        + ", Domicilio: " + rs.getString("domicilio")
                        + ", Telefono: " + rs.getString("telefono")
                        + ", Fecha Nacimiento: " + rs.getDate("fechaNacimiento")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarContenidoPrestamos() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        System.out.println("\uD83D\uDCB0 PRESTAMOS \uD83D\uDCB0");
        try {
            consulta = miCon.prepareStatement("SELECT * FROM Prestamos");

            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                System.out.println(" Id-Libro:" + rs.getInt("codigoLibro")
                        + ", Id-Socio: " + rs.getInt("codigoSocio")
                        + ", Fecha de Inicio: " + rs.getDate("fechaInicio")
                        + ", Fecha de Finalización: " + rs.getDate("fechaFin")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static String crearTablaLibro() {

        return "("
                + "Codigo INT(64) NOT NULL PRIMARY KEY,"
                + "Titulo VARCHAR(30),"
                + "Editorial VARCHAR(25),"
                + "Año INT,"
                + "ISBN VARCHAR(30) NOT NULL UNIQUE,"
                + "NumEjemplares INT(64),"
                + "NumPaginas INT(64))";

    }

    public static String crearTablaSocio() {

        return "("
                + "Codigo INT(64) NOT NULL PRIMARY KEY,"
                + "Nombre VARCHAR(30),"
                + "Apellidos VARCHAR(30),"
                + "fechaNacimiento DATE,"
                + "Domicilio VARCHAR(40),"
                + "Telefono VARCHAR(15))";

    }

    public static String crearTablaPrestamo() {

        return "("
                + "codigoLibro INT(64) NOT NULL,"
                + "codigoSocio INT(64) NOT NULL,"
                + "fechaInicio Prestamo DATE,"
                + "fechaFin Prestamo DATE,"
                + "PRIMARY KEY(codigoLibro, codigoSocio),"
                + "FOREIGN KEY(codigoSocio) REFERENCES Socio(Codigo),"
                + "FOREIGN KEY(codigoLibro) REFERENCES Libro(Codigo))";

    }
}


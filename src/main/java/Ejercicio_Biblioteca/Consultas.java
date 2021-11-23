package Ejercicio_Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Consultas {
    //Colores de error
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    //Incio Consultas
    public static void mostrarTablas() throws SQLException {
        Connection miCon = Conexion.conectar();

        ResultSet rs = miCon.getMetaData().getTables(null, null, null, null);
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
        miCon.close();
        rs.close();
        
    }

    //Metodo para mostrar el contenido de la tabla libros
    public static void mostrarContenidoLibros() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        System.out.println("\uD83D\uDCD6 LIBROS \uD83D\uDCD6");
        try {
            consulta = miCon.prepareStatement("SELECT * FROM Libros");
            //consultaLibros = miCon.prepareStatement("")
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                System.out.println(" Id:" + rs.getInt("codigo")
                        + " TITULO: " + rs.getString("titulo")
                        + ", Editorial: " + rs.getString("editorial")
                        + ", ISBN: " + rs.getString("ISBN")
                        + ", Año: " + rs.getString("Año")
                        + ", Nº Ejemplares: " + rs.getInt("numEjemplares")
                        + ", Nº Páginas: " + rs.getInt("numPaginas")

                );
            }
            miCon.close();
            rs.close();
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Metodo para mostrar el contenido de la tabla Socios
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
            miCon.close();
            rs.close();
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para mostrar el contenido de la tabla Prestamos
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
                        + ", Fecha de Inicio: " + rs.getDate("fechaInicioPrestamo")
                        + ", Fecha de Finalización: " + rs.getDate("fechaFinPrestamo")
                );
            }
            miCon.close();
            rs.close();
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Cantidad de libros prestados de la biblioteca (contenido de "Prestamos")
    public static void listaLibrosPrestados() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        System.out.println("\n\uD83D\uDCC2 Cantidad de libros prestados actulamente: ");
        try {
            consulta = miCon.prepareStatement("SELECT COUNT(codigoLibro) FROM Prestamos");

            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                System.out.println("-> " + rs.getInt(1));
            }
            miCon.close();
            rs.close();
            consulta.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Libros prestados a socio especifico
    public static void listaLibrosPrestadosSocio(int codigoSocio) {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        System.out.println("\n\uD83D\uDCC2 Cantidad de libros prestados a socio con Id: " + codigoSocio);
        try {
            consulta = miCon.prepareStatement("SELECT COUNT(codigoSocio) FROM Prestamos WHERE codigoSocio = " + codigoSocio);

            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) > 0) {

                    System.out.println("-> " + rs.getInt(1));

                } else {
                    System.out.println("-> " + rs.getInt(1));

                    System.out.println(ANSI_YELLOW + "Socio especificado sin prestamos activos" + ANSI_RESET);
                }

            }
            miCon.close();
            rs.close();
            consulta.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Metodo de listado de libros expirados
    public static void listadoLibrosPrestadosExipirados() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        long tiempo = System.currentTimeMillis();
        Date tiempoActual = new Date(tiempo);

        System.out.println("\n\uD83D\uDCC2 Cantidad de libros prestados que han exedido la fecha límite: ");
        try {
            consulta = miCon.prepareStatement("SELECT * FROM Libros WHERE codigo IN (SELECT codigoLibro FROM Prestamos WHERE fechaFinPrestamo < " + tiempoActual.getTime() + ")");

            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                System.out.println("Libro encontrado: ");
                System.out.println("-> Id: " + rs.getInt("Codigo")
                        + (", Título: " + rs.getString("titulo"))
                        + (", ISBN: " + rs.getString("ISBN"))
                );

            }
            miCon.close();
            rs.close();
            consulta.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Metodo de listado de libros expirados por socios
    public static void listadoLibrosPrestadosExipiradosPorSocio() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        long tiempo = System.currentTimeMillis();
        Date tiempoActual = new Date(tiempo);

        System.out.println("\n\uD83D\uDCC2 Libros prestados a socios que han exedido la fecha límite: ");
        try {
            consulta = miCon.prepareStatement("SELECT * FROM Socios WHERE codigo IN (SELECT codigoSocio FROM Prestamos WHERE fechaFinPrestamo < " + tiempoActual.getTime() + ")");

            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                System.out.println("Socio encontrado: ");
                System.out.println("Id: " + rs.getInt("Codigo")
                        + (", Nombre: " + rs.getString("nombre"))
                        + (", Appellidos: " + rs.getString("apellidos"))
                        + (", Teléfono: " + rs.getString("telefono"))
                );

            }
            miCon.close();
            rs.close();
            consulta.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
                + "fechaInicioPrestamo DATE,"
                + "fechaFinPrestamo DATE,"
                + "PRIMARY KEY(codigoLibro, codigoSocio),"
                + "FOREIGN KEY(codigoSocio) REFERENCES Socio(Codigo),"
                + "FOREIGN KEY(codigoLibro) REFERENCES Libro(Codigo))";

    }
}


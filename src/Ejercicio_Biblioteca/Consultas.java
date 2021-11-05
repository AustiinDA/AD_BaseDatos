package Ejercicio_Biblioteca;

public class Consultas {
    public static String crearTablaLibro() {
        String tablaLibro = "CREATE TABLE Libro ("
                + "Codigo INT(64) NOT NULL PRIMARY KEY,"
                + "Título VARCHAR(30),"
                + "Editorial VARCHAR(25),"
                + "Año INT(4),"
                + "ISBN VARCHAR(30) NOT NULL UNIQUE,"
                + "Num. Ejemplares INT(64),"
                + "Num. Páginas INT(64))";

        return tablaLibro;
    }

    public static String crearTablaSocio() {

        String tablaSocio = "CREATE TABLE Socio ("
                + "Código INT(64) NOT NULL PRIMARY KEY,"
                + "Nombre VARCHAR(30),"
                + "Apellidos VARCHAR(30),"
                + "Fecha Nacimiento DATE(),"
                + "Domicilio VARCHAR(40),"
                + "Teléfono VARCHAR(15))";
        return tablaSocio;
    }

    public static String crearTablaPrestamo() {

        String tablaPrestamo = "CREATE TABLE Préstamo ("
                + "Código Libro INT(64) NOT NULL PRIMARY KEY FOREIGN KEY(Libro),"
                + "Código Socio INT(64) NOT NULL PRIMARY KEY FOREIGN KEY(Socio),"
                + "Fecha Inicio Prestamo DATE(),"
                + "Fecha Fin Prestamo DATE())";
        return crearTablaPrestamo();
    }
}


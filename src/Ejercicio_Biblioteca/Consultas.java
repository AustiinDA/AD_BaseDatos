package Ejercicio_Biblioteca;

public class Consultas {

    public static String mostrarTablas(){
        return ".tables";
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

        return"("
                + "Codigo INT(64) NOT NULL PRIMARY KEY,"
                + "Nombre VARCHAR(30),"
                + "Apellidos VARCHAR(30),"
                + "fechaNacimiento DATE,"
                + "Domicilio VARCHAR(40),"
                + "Teléfono VARCHAR(15))";

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


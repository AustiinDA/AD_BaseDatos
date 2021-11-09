package Ejercicio_Biblioteca;

public class Consultas {

    public static void mostrarTablas(){
        Conexion.conectar();
        String consulta = ".tables";
        System.out.println("xd");


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
                + "Fecha Nacimiento DATE,"
                + "Domicilio VARCHAR(40),"
                + "Teléfono VARCHAR(15))";

    }

    public static String crearTablaPrestamo() {

        return "("
                + "Codigo Libro INT(64) NOT NULL PRIMARY KEY FOREIGN KEY(Libro),"
                + "Codigo Socio INT(64) NOT NULL PRIMARY KEY FOREIGN KEY(Socio),"
                + "Fecha Inicio Prestamo DATE,"
                + "Fecha Fin Prestamo DATE)";

    }
}


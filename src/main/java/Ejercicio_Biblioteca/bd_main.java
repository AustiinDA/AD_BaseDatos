package Ejercicio_Biblioteca;

import java.sql.SQLException;

public class bd_main {
    public static void main(String[] args) throws SQLException {
        //Creacion de base de datos y tablas
        CreacionBD.crearDB();
        CreacionTablas.crearTabla("Libros", Consultas.crearTablaLibro());
        CreacionTablas.crearTabla("Socios", Consultas.crearTablaSocio());
        CreacionTablas.crearTabla("Prestamos", Consultas.crearTablaPrestamo());
        Consultas.mostrarTablas();

        //Inserccion de los datos de las tablas
        insercionDatos.crearDatosTablas();

        insercionDatos.insertarLibros();
        insercionDatos.insertarSocios();
        insercionDatos.insertarPrestamo();

        //Metodos de contenido de tablas
        Consultas.mostrarContenidoLibros();
        Consultas.mostrarContenidoSocios();
        Consultas.mostrarContenidoPrestamos();

        //Consultas sobre las tablas
        Consultas.listaLibrosPrestados();
        Consultas.listaLibrosPrestadosSocio(3);
        Consultas.listaLibrosPrestadosSocio(2);
        Consultas.listadoLibrosPrestadosExipirados();
        Consultas.listadoLibrosPrestadosExipiradosPorSocio();
    }
}
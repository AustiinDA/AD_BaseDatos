package Ejercicio_Biblioteca;

import java.sql.SQLException;

public class bd_main {
    public static void main(String[] args) throws SQLException {
        CreacionBD.crearDB();
        CreacionTablas.crearTabla("Libros", Consultas.crearTablaLibro());
        CreacionTablas.crearTabla("Socios", Consultas.crearTablaSocio());
        CreacionTablas.crearTabla("Prestamos", Consultas.crearTablaPrestamo());
        Consultas.mostrarTablas();

        insercionDatos.crearDatosTablas();

        insercionDatos.insertarLibros();
        insercionDatos.insertarSocios();
        insercionDatos.insertarPrestamo();

        Consultas.mostrarContenidoLibros();
        Consultas.mostrarContenidoSocios();
        Consultas.mostrarContenidoPrestamos();

        Consultas.listaLibrosPrestados();
        Consultas.listaLibrosPrestadosSocio(3);
        Consultas.listaLibrosPrestadosSocio(2);
        Consultas.listadoLibrosPrestadosExipirados();
        Consultas.listadoLibrosPrestadosExipiradosPorSocio();
    }
}
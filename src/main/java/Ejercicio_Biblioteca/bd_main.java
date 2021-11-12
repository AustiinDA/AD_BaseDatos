package Ejercicio_Biblioteca;

public class bd_main {
    public static void main(String[] args) {
        CreacionBD.crearDB();
        CreacionTablas.crearTabla("Libros", Consultas.crearTablaLibro());
        CreacionTablas.crearTabla("Socios", Consultas.crearTablaSocio());
        CreacionTablas.crearTabla("Prestamos", Consultas.crearTablaPrestamo());
        Consultas.mostrarTablas();

    }
}
package Ejercicio_Biblioteca;

public class bd_main {
    public static void main(String[] args) {
        CreacionBD.crearDB();
        CreacionTablas.crearTabla("Libro", Consultas.crearTablaLibro());
        Consultas.mostrarTablas();


    }
}
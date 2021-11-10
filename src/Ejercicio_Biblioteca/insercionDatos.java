package Ejercicio_Biblioteca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;


public class insercionDatos {

    public void crearDatosTablas() {

        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Socio> socios = new ArrayList<>();
        ArrayList<Prestamo> prestamos = new ArrayList<>();


        libros.add(new Libro(1, "El conde de monte cristo", "Frachueli", "43290-212B", 1846, 312, 720));
        libros.add(new Libro(2, "Robots e Imperio", "Plaza & Janes ", "8401321697", 1986, 12, 512));
        libros.add(new Libro(3, "El sol desnudo", " DEBOLS!LLO", "8497937856", 2019, 55, 288));
        libros.add(new Libro(4, "Tales Of Mystery And Imagination", "W&N", " 978-0460873420", 1993, 32, 640));
        libros.add(new Libro(5, "Paisajes y apariciones", "Libros del Zorro Rojo", " 8412061101", 2019, 53, 72));

    }


    public static Date fechaTransform(String fechaSQL) {
        Date fecha = null;

        java.util.Date d = new java.util.Date();
        SimpleDateFormat formateoFecha = new SimpleDateFormat("dd-MM-yyyy");
        try {
            String fechaFormateada = formateoFecha.format(fechaSQL);
            fecha = java.sql.Date.valueOf(fechaFormateada);
        } catch (Exception e) {
            String fechaFormateada = formateoFecha.format(fecha);
        }
        return fecha;
    }
}

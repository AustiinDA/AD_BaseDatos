package Ejercicio_Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;


public class insercionDatos {

    public static ArrayList<Libro> libros = new ArrayList<>();
    public static ArrayList<Socio> socios = new ArrayList<>();
    public static ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void crearDatosTablas() {

        libros.add(new Libro(1, "El conde de monte cristo", "Frachueli", "43290-212B", 1846, 312, 720));
        libros.add(new Libro(2, "Robots e Imperio", "Plaza & Janes ", "8401321697", 1986, 12, 512));
        libros.add(new Libro(3, "El sol desnudo", " DEBOLS!LLO", "8497937856", 2019, 55, 288));
        libros.add(new Libro(4, "Tales Of Mystery And Imagination", "W&N", " 978-0460873420", 1993, 32, 640));
        libros.add(new Libro(5, "Paisajes y apariciones", "Libros del Zorro Rojo", " 8412061101", 2019, 53, 72));

        socios.add(new Socio(1, "Jackie", "Chan", "Hong Kong, Tin Wan, Yue Ko St, 1號Aberdeen 號地下", "8616532924932", fechaTransform("07-04-1954")));
        socios.add(new Socio(2, "Hugh", "Jackman", "45 Blackwall Point Rd, Chiswick NSW 2046, Australia", "0491 570 156", fechaTransform("12-10-1968")));
        socios.add(new Socio(3, "Neil", "Gaiman", "10 The Fairway, Portchester, Fareham PO16 8NS, Reino Unido", "01632 960980", fechaTransform("10-11-1960")));

        prestamos.add(new Prestamo(1, 2, fechaTransform("02-04-2019"), fechaTransform("12-12-2021")));
        prestamos.add(new Prestamo(3, 1, fechaTransform("12-09-2021"), fechaTransform("31-12-2021")));

        System.out.println("-- Datos procesados --");

    }

    public static void insertarLibros() {
        Connection miCon = Conexion.conectar();
        PreparedStatement consulta;

        try {
            for (Libro libro : libros) {
                consulta = miCon.prepareStatement("INSERT IGNORE INTO libros(codigo, titulo, editorial, ISBN, año, numEjemplares, numPaginas) VALUES(?, ?, ?, ?, ?, ?, ?)");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

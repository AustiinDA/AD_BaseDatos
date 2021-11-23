package Ejercicio_Biblioteca;

import java.sql.Date;

public class Socio {

int codigo;
String Nombre, Apellidos, Domicilio, Telefono;
Date fechaNacimiento;
    //Constructor de los Socios

    public Socio(int codigo, String nombre, String apellidos, String domicilio, String telefono, Date fechaNacimiento) {
        this.codigo = codigo;
        Nombre = nombre;
        Apellidos = apellidos;
        Domicilio = domicilio;
        Telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
    //Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "codigo=" + codigo +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Domicilio='" + Domicilio + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}

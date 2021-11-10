package Ejercicio_Biblioteca;

import java.sql.Date;

public class Prestamo {

    int codigoLibro, codigoSocio;
    Date fechaInicio, fechaFin;

    public Prestamo(int codigoLibro, int codigoSocio, Date fechaInicio, Date fechaFin) {
        this.codigoLibro = codigoLibro;
        this.codigoSocio = codigoSocio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public int getCodigoSocio() {
        return codigoSocio;
    }

    public void setCodigoSocio(int codigoSocio) {
        this.codigoSocio = codigoSocio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "codigoLibro=" + codigoLibro +
                ", codigoSocio=" + codigoSocio +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}

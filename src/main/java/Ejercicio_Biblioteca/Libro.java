package Ejercicio_Biblioteca;

public class Libro {

    int Codigo, Año, NumEjemplares, NumPaginas;
    String Titulo, Editorial, ISBN;

    public Libro(int codigo, String titulo, String editorial, String ISBN, int año, int numEjemplares, int numPaginas) {
        Codigo = codigo;
        Titulo = titulo;
        Editorial = editorial;
        this.ISBN = ISBN;
        Año = año;
        NumEjemplares = numEjemplares;
        NumPaginas = numPaginas;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int año) {
        Año = año;
    }

    public int getNumEjemplares() {
        return NumEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        NumEjemplares = numEjemplares;
    }

    public int getNumPaginas() {
        return NumPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        NumPaginas = numPaginas;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Codigo=" + Codigo +
                ", Año=" + Año +
                ", NumEjemplares=" + NumEjemplares +
                ", NumPaginas=" + NumPaginas +
                ", Titulo='" + Titulo + '\'' +
                ", Editorial='" + Editorial + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}

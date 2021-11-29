package XAMP;

public class Pelicula {
    String titulo, director, genero;
    int año, duracion;

    public Pelicula(String titulo, String director, String genero, int año, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.año = año;
        this.duracion = duracion;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Película:" +
                " Título: " + titulo
                + ", Director: " + director
                + ", Género: " + genero
                + ", Año: " + año
                + ", Duración: " + duracion +" min";
    }
}

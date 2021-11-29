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

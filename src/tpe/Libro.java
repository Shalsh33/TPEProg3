package src.tpe;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Libro {

    private String titulo;
    private String autor;
    private int pag;
    private Set<String> generos;

    public Libro(){
        generos = new HashSet<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    public void addGenero(String genero){
        generos.add(genero);
    }

    public void removeGenero(String genero){
        generos.remove(genero);
    }

    public boolean hasGenero(String genero){
        return generos.contains(genero);
    }

    public Iterator<String> getGeneros(){
        return generos.iterator();
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", pag=" + pag +
                ", generos=" + generos +
                '}';
    }
}

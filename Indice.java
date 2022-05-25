package tpe;

import java.util.*;

public class Indice {

    private Map<String, Set<Libro>> generos;

    public Indice() {
        generos = new HashMap<>();
    }

    public void indexar(Libro libro){
        Iterator<String> generosLibro = libro.getGeneros();
        while(generosLibro.hasNext()){
            String genero = generosLibro.next();
            indexar(libro,genero);
        }
    }

    private void indexar(Libro libro, String genero){
        if(generos.containsKey(genero)){
            generos.get(genero).add(libro);
        } else {
            generos.put(genero, new HashSet<>());
            generos.get(genero).add(libro);
        }
    }
}

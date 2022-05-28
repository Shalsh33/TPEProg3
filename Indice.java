package tpe;

import java.util.*;

public class Indice {


    private Tree<String> generos;

    public Indice() {

    }

    public void indexar(Libro libro){
        Iterator<String> generosLibro = libro.getGeneros();
        while(generosLibro.hasNext()){
            String genero = generosLibro.next();

        }
    }

    /*private void indexar(Libro libro, String genero){
        if(generos.containsKey(genero)){
            generos.get(genero).add(libro);
        } else {
            generos.put(genero, new HashSet<>());
            generos.get(genero).add(libro);
        }
    }*/
}

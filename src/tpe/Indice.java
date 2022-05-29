package src.tpe;

import java.util.*;

public class Indice {


    private TreeWithNode generos;

    public Indice() {
    	TreeWithNode generos = new TreeWithNode() ;
    }

    public void indexar(Libro libro){
        Iterator<String> generosLibro = libro.getGeneros();
        while(generosLibro.hasNext()){
            String genero = generosLibro.next();
            generos.add(genero);
            generos.agregarLibro(genero, libro);

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

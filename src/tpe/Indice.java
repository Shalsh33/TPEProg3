package src.tpe;

import java.util.*;

public class Indice {


    private TreeWithNode generos;

    public Indice() {
    	this.generos = new TreeWithNode() ;
    }

    public void indexar(Libro libro){
        Iterator<String> generosLibro = libro.getGeneros();
        while(generosLibro.hasNext()){
            String genero = generosLibro.next();
            generos.add(genero);
            generos.agregarLibro(genero, libro);

        }
    }
    
    public void imprimirGeneros(){
    	//generos.printPosOrder();
    	generos.printInOrder();
    }
    
    public void getIndiceGenero(String genero){
    	generos.getLibrosGenero(genero);
    }
    
}

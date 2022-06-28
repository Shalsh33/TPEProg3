package src.tpe;

import src.tpe.assets.CSVWritter;

import java.util.*;

public class Indice {


    private TreeWithNode generos;

    public Indice() {
        this.generos = new TreeWithNode() ;
    }

    public void indexar(Libro libro){
        if(libro != null){
            Iterator<String> generosLibro = libro.getGeneros();
            while(generosLibro.hasNext()){
                String genero = generosLibro.next();
                generos.add(genero);
                generos.agregarLibro(genero, libro);

            }
        }
    }

    public void imprimirGeneros(){
        //generos.printPosOrder();
        generos.printInOrder();
    }

    public void getIndiceGenero(String genero, String pathOut){
        List<Libro> libros = generos.getLibrosGenero(genero.toLowerCase());
        CSVWritter.writeLibros(libros, pathOut);
    }
    
    public void imprimirDatosIndice(){
        generos.printAltura();
        generos.printCantNodos();
    }

}

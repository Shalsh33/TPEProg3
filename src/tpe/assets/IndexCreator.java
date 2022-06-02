package tpe.assets;

import tpe.*;


public class IndexCreator {

    private Indice indice;

    public IndexCreator(){
        indice = new Indice();
    }

    public void indexar(Libro libro){
        if(libro != null){
            indice.indexar(libro);
        }
    }

    public void indexar(String[] libro){
        indexar(LibroFormatter.format(libro));
    }


    public Indice getIndice(){
        return indice;
    }


}

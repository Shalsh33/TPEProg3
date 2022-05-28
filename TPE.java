package tpe;

import tpe.assets.CSVReader;
import java.util.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class TPE {

    public static void main(String[] args){
<<<<<<< HEAD
        Indice indice = CSVReader.read();

        List<Libro> libros = new LinkedList<>();

=======
        
        LinkedList<Libro> lista = new LinkedList();
        Indice indice = CSVReader.read(lista);
        
>>>>>>> bf27d5892c107108557ed8145e79172c483a5b73
    }


}

package tpe;

import tpe.assets.CSVReader;
import java.util.LinkedList;

public class TPE {

    public static void main(String[] args){
        
        LinkedList<Libro> lista = new LinkedList();
        Indice indice = CSVReader.read(lista);
        
    }


}
